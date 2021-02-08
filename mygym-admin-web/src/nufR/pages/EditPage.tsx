import axios from 'axios';
import React, {useState, useEffect} from 'react'
import Spinner from '../../layout/Spinner';
import { useNUFRConfig } from '../Hooks';
import {  IModelObjectRecord } from './ListPage';
import { useParams } from "react-router";
import { validateTruthy } from "validation-utils";
import PageTitle from './PageTitle';

import Form from "@rjsf/material-ui";
import MuiAlert, { AlertProps } from '@material-ui/lab/Alert';
import { Snackbar } from '@material-ui/core';

/**
 * defaulty values model object
 */
const defaultModelObject : IModelObjectRecord = {
    "id": -1 , 
    "loadtime":0, 
    "dirty":false
}

interface IEditPageProps {
    configname:string
    mode:string // add or edit
}

function Alert(props: AlertProps) {
    return <MuiAlert elevation={6} variant="filled" {...props} />;
}

const EditPage = (props:IEditPageProps) => {

    // load nuf , the config name is in the props
    const configHookRes = useNUFRConfig( props.configname );
    const [loading, setLoading] = useState(true);
    const [openSnack, setOpenSnack] = useState(false);
    const [currentRecord, setCurrentRecord] = useState<IModelObjectRecord>(defaultModelObject);
    const idParams:any  = useParams(); // get the id parameter from the URL, which is in the form /:id
    const idParam:string = idParams.id;

    const saveRecord = async (formData:IModelObjectRecord) => {
        const result = await axios(configHookRes.config.getSaveApiUrl(), { method:"POST" } );
        setCurrentRecord(result.data.results);
    } 

    const doOpenSnack = () => {
        setOpenSnack(true);
      };

    useEffect(() => {
        console.log("useEffect of edit page:" + configHookRes.config);
        setLoading(true);
        if (configHookRes.config.key) {
            console.log("props.mode:" + props.mode);
            validateTruthy( props.mode === "add" || props.mode === "edit", "Mode Can be \"add\" or \"edit\"");
            validateTruthy( props.mode === "add" || (props.mode === "edit" &&  idParam), "id Parameter must be set when mode is \"edit\"");

            
            const fetchData = async () => {
                const result = await axios(configHookRes.config.getEditAPIUrl(idParam));
                setCurrentRecord(result.data.results);
                doOpenSnack();  
            };

            if (idParam) { // if id param was passed as a parameter, load the record
                fetchData();
            } else {
                // this is add new mode. lets just set the current obejct to the default model object
                setCurrentRecord(defaultModelObject);
            }
            setLoading(false);
        }
        return;
        // eslint-disable-next-line
    }, [configHookRes.config]);

    console.log("rendering.... xxx ");
    return (

        <>
        <Spinner loading={loading||configHookRes.loading} message={configHookRes.config.spinnerMessage} ></Spinner>
        <PageTitle config={configHookRes.config} labelKey={props.mode} />
        {loading===false &&
            <>
            <Form id={`frm_${configHookRes.config.key}`} 
                        liveValidate={false } 
                        showErrorList={true}
                        noHtml5Validate={true} 
                        schema={configHookRes.config.formSchema} 
                        formData={currentRecord}
                        onSubmit={e => { e.formData.dirty = true && saveRecord(e.formData)  } }
                        onChange={e => { e.formData.dirty = true; setCurrentRecord(e.formData);  }} >
                
            </Form>
            <div>
                {JSON.stringify(currentRecord)}
            </div>
            <Snackbar open={openSnack} autoHideDuration={6000} onClose={handleClose}>
                <Alert onClose={handleClose} severity="success">
                This is a success message!
                </Alert>
            </Snackbar>
            </>
        }       

        </>
    )
}

export default EditPage

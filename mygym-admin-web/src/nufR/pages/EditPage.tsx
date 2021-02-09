import axios from 'axios';
import React, {useState, useEffect} from 'react'
import Spinner from '../../layout/Spinner';
import { useNUFRConfig } from '../Hooks';
import {  IModelObjectRecord } from './ListPage';
import { useParams } from "react-router";
import { validateTruthy } from "validation-utils";
import PageTitle from './PageTitle';

import Form from "@rjsf/material-ui";
import { useSnackbar } from 'notistack';
import { useTranslation } from 'react-i18next';

/**
 * defaulty values model object
 */
const defaultModelObject : IModelObjectRecord = {
    "id": -1 , 
    "loadtime":0, 
    "dirty":false,
    "jsonDirty":false
}

interface IEditPageProps {
    configname:string
    mode:string // add or edit
}

const EditPage = (props:IEditPageProps) => {

    const { enqueueSnackbar, closeSnackbar } = useSnackbar();
    const { t } = useTranslation();
    
    const configHookRes = useNUFRConfig( props.configname );
    const [loading, setLoading] = useState(true);
    
    const [currentRecord, setCurrentRecord] = useState<IModelObjectRecord>(defaultModelObject);
    const idParams:any  = useParams(); // get the id parameter from the URL, which is in the form /:id
    const idParam:string = idParams.id;

    const saveRecord = async (formData:IModelObjectRecord) => {
        await axios(configHookRes.config.getSaveApiUrl(), { method:"POST", data: currentRecord  } ).then(function(result){
            setCurrentRecord(result.data.results);
            enqueueSnackbar( t('save.success') , { 
                variant: 'success',
            });
        }).catch(function(){
            enqueueSnackbar( t('save.failed') , { 
                variant: 'error',
            });
        });
        
        
    } 

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
        <PageTitle config={configHookRes.config} suffixLabelKey={props.mode} />
        {loading===false &&
            <>
            <Form id={`frm_${configHookRes.config.key}`} 
                        liveValidate={false } 
                        showErrorList={true}
                        noHtml5Validate={true} 
                        schema={configHookRes.config.formSchema} 
                        formData={currentRecord}
                        onSubmit={e => { e.formData.jsonDirty && saveRecord(e.formData)  } }
                        onChange={e => { e.formData.jsonDirty=true; setCurrentRecord(e.formData);  }} >
                
            </Form>
            <div>
                {JSON.stringify(currentRecord)}
            </div>
            
            </>
        }       

        </>
    )
}

export default EditPage

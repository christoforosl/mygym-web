import axios from 'axios';
import React, {useState, useEffect} from 'react'
import Spinner from '../../layout/Spinner';
import { useNUFRConfig } from '../Hooks';
import {  IModelObjectRecord } from './ListPage';
import { useParams } from "react-router";
import { validateTruthy } from "validation-utils";
import PageTitle from './PageTitle';

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

const EditPage = (props:IEditPageProps) => {

    // load nuf , the config name is in the props
    const configHookRes = useNUFRConfig( props.configname );
    const [loading, setLoading] = useState(true);
    const [currentRecord, setCurrentRecord] = useState<IModelObjectRecord>(defaultModelObject);
    const idParams:any  = useParams(); // get the id parameter from the URL, which is in the form /:id
    const idParam:string = idParams.id;

    useEffect(() => {
        console.log("useEffect of edit page:" + configHookRes.config);
        if (configHookRes.config.key) {
            console.log("props.mode:" + props.mode);
            validateTruthy( props.mode === "add" || props.mode === "edit", "Mode Can be \"add\" or \"edit\"");
            validateTruthy( props.mode === "edit" &&  idParam, "id Parameter must be set when mode is \"edit\"");

            setLoading(true);
            const fetchData = async () => {
                const result = await axios(configHookRes.config.getEditAPIUrl(idParam));
                setCurrentRecord(result.data.results);
                setLoading(false);
            };

            if (idParam) { // if id param was passed as a parameter, load the record
                fetchData();
            } else {
                // this is add new mode. lets just set the current obejct to the default model object
                setCurrentRecord(defaultModelObject);
            }
        }
        return;
        // eslint-disable-next-line
    }, [configHookRes.config]);


    const handleInputChange = (event: { target: { name: any; value: any; }; }) => {
        const {name, value} = event.target;
        setCurrentRecord({...currentRecord, [name]: value});
    }

    return (
        <>
        <Spinner loading={loading||configHookRes.loading} message={configHookRes.config.spinnerMessage} ></Spinner>
        <PageTitle config={configHookRes.config}/>
        <form>
            <label>Id</label>
            <input type="text" name="id" value={currentRecord.id} onChange={handleInputChange}/>
            
            <button className="button muted-button">
                Cancel
            </button>
        </form>
        </>
    )
}

export default EditPage

import axios from 'axios';
import React, {useState, useEffect} from 'react'
import Spinner from '../../layout/Spinner';
import { IConfig, IModelObjectRecord } from './ListPage';

/**
 * defaulty values model object
 */
const defaultModelObject : IModelObjectRecord = {
    "id": -1 , 
    "loadtime":0, 
    "dirty":false
}

export const defaultConfig = new IConfig();

interface IEditPageProps {
    id:string
}

const EditPage = (props:IEditPageProps) => {

    const [config, setConfig] = useState<IConfig>(defaultConfig);
    const [loading, setLoading] = useState(true);
    const [currentRecord, setCurrentRecord] = useState<IModelObjectRecord>(defaultModelObject);
    
    useEffect(() => {
        setLoading(true);
        const fetchData = async () => {
            const result = await axios(config.getEditAPIUrl(props.id));
            setCurrentRecord(result.data.results);
            setLoading(false);
        };
        fetchData();
        return;
        // eslint-disable-next-line
    }, [config]);


    const handleInputChange = (event: { target: { name: any; value: any; }; }) => {
        const {name, value} = event.target;
        setCurrentRecord({...currentRecord, [name]: value});
    }

    return (
        <>
        <Spinner loading={loading} message={config.spinnerMessage} ></Spinner>
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

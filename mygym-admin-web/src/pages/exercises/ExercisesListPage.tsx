
import config from "../../globals/AppVars.json"

import ReactDataGrid from 'react-data-grid';
import { useState, useEffect } from 'react';
import Spinner from '../../layout/Spinner';

const axios = require('axios').default;


const columns = [
    { key: 'exerciseDefinitionId', name: 'ID', width:5 },
    { key: 'name', name: 'Name' },
    { key: 'description', name: 'Description' } ];

export default function ExercisesListPage() {

    const [data, setData] = useState( [] );
    const url:string = process.env.REACT_APP_API_ROOT+config.apiEndPoints.getExerciseList.url;

    useEffect(() => {
        const fetchData = async () => {
          const result = await axios( url );
          setData(result.data.results);
        };
     
        fetchData();
    }, [url]);
        
    return (
        data.length > 0 ? 
        <ReactDataGrid
                columns={columns}
                rows={data}
                
                 /> : <Spinner message="loading exercises" ></Spinner>);

            
}

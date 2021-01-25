
import config from "../../globals/AppVars.json"

import ReactDataGrid from 'react-data-grid';
import { Fragment } from 'react';
import { useState, useEffect } from 'react';

const axios = require('axios').default;


const columns = [
    { key: 'exerciseDefinitionId', name: 'ID' },
    { key: 'name', name: 'Name' },
    { key: 'description', name: 'Description' } ];

export default function ExercisesListPage() {

    const [data, setData] = useState( [] );
    const url:string = process.env.REACT_APP_API_ROOT+config.apiEndPoints.getExerciseList.url;

    useEffect(() => {
        const fetchData = async () => {
          const result = await axios( url );
          console.log("data length:" + JSON.stringify( result.data.results.length) ) ;
          setData(result.data.results);
        };
     
        fetchData();
    }, [url]);
    
    // return (
    // <ul>
    //     {data.map(item => (
    //       <li key={item.exerciseDefinitionId}>
    //         {item.name}
    //       </li>
    //     ))}
    //   </ul>);

    
    return (
        data.length > 0 ? 
        <ReactDataGrid
                columns={columns}
                rowGetter={i => data[i]}
                rowsCount={data.length}
                 /> : <Fragment>Loading...</Fragment>);

            
}

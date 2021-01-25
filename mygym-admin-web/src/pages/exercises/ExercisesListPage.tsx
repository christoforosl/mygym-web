
import config from "../../globals/AppVars.json"
import { apiResults } from "../../nufR/APICallerUtils"
import ReactDataGrid from 'react-data-grid';
import { Fragment } from 'react';
import { useState, useEffect } from 'react';

const axios = require('axios').default;

interface IExercise {
    exerciseDefinitionId: number;
    name: string;
    description: string;
  }

const defaultProps:IExercise[] = [];

const columns = [
    { key: 'exerciseDefinitionId', name: 'ID' },
    { key: 'name', name: 'Name' },
    { key: 'description', name: 'Description' } ];

export default function ExercisesListPage() {

    const [data, setData]: [IExercise[], (posts: IExercise[]) => void] = useState(defaultProps);
    const url:string = process.env.REACT_APP_API_ROOT+config.apiEndPoints.getExerciseList.url;

    useEffect(() => {
        const fetchData = async () => {
          const result = await axios( url );
          console.log("data:" + JSON.stringify( result.data.results) ) ;
          setData(result.data.results);
        };
     
        fetchData();
    }, []);
    
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
                rows={data}
                minHeight={150} /> : <Fragment>Loading...</Fragment>);

            
}

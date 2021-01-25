
import config from "../../globals/AppVars.json"
import { apiResults } from "../../nufR/APICallerUtils"
import ReactDataGrid from 'react-data-grid';
import { Fragment } from 'react';
import { useEffect } from 'react';

const axios = require('axios').default;

const columns = [
    { key: 'exerciseDefinitionId', name: 'ID' },
    { key: 'name', name: 'Name' },
    { key: 'description', name: 'Description' } ];

export default function ExercisesListPage() {
    
    const url:string = process.env.REACT_APP_API_ROOT+config.apiEndPoints.getExerciseList.url;

    useEffect(() => {
        var data  = axios.get(url)
        .then( (response: any) => {
            // handle success
            if (response.status==='ERROR') {
                throw response.error;
            }
            //console.log( response.data );
            const ret: apiResults = response.data;
            return ret.results);
        
        console.log("data:" + JSON.stringify(data));

    },[]));

    return (
        data ? 
        <ReactDataGrid
                columns={columns}
                rowGetter={i => data[i]}
                rowsCount={10}
                minHeight={150} /> : <Fragment>Loading...</Fragment>);
    
    
}

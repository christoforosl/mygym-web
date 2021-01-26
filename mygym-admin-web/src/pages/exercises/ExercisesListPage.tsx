
import config from "../../globals/AppVars.json"

import ReactDataGrid from 'react-data-grid';
import { useState, useEffect, Fragment } from 'react';
import Spinner from '../../layout/Spinner';

const axios = require('axios').default;

const columns = [
    { key: 'exerciseDefinitionId', name: 'ID', width: 1 },
    { key: 'editButtons', name: '', width: 1, formatter(props:any) { return <EditButtonsFormatter id={props.row.id}></EditButtonsFormatter>}},
    { key: 'name', name: 'Name' },
    { key: 'description', name: 'Description' },
    { key: 'equipment', name: 'Equipment' },
    { key: 'createDate', name: 'Created' , formatter(props:any) {
            return <DateTimeFormatter dateVal={props.row.createDate} />;
        }},
    { key: 'updateDate', name: 'Updated' , formatter(props:any) {
            return <DateTimeFormatter dateVal={props.row.createDate} />;
        }}
    
     ];

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
        <Fragment>
        <div className="pageTitle">{pageTitle}</div>
        <Fragment> {data.length > 0 } ? 
            <ReactDataGrid
                    columns={columns}
                    rows={data} /> : <Spinner message="Loading Exercises ..." ></Spinner> </Fragment>
        </Fragment>
        ); 

            
}

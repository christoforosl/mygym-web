

import ReactDataGrid from 'react-data-grid';
import { useState, useEffect, Fragment } from 'react';
import Spinner from '../../layout/Spinner';


const axios = require('axios').default;

export interface IConfig  {
    name:string,
    getListDataUrl:string,
    pageTitle:string,
    spinnerMessage?:string
    columns:[any,any,any,any,any,any,any]
}

export interface IListPageProps  {
    config:IConfig
}

export default function ListPage({ config }: IListPageProps) {

    const [data, setData] = useState( [] );
    const url:string = config.getListDataUrl;

    useEffect(() => {
        const fetchData = async () => {
          const result = await axios( url );
          setData(result.data.results);
        };
    
        fetchData();
    }, [url]);
        
    return (
        <Fragment>
        <div className="pageTitle">{config.pageTitle}</div>
        <Fragment> {data.length > 0 } ? 
            <ReactDataGrid
                    columns={config.columns}
                    rows={data} /> : <Spinner message={config.spinnerMessage || "Loading ..."} ></Spinner> </Fragment>
        </Fragment>
        ); 

            
}

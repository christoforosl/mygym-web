
import ReactDataGrid from 'react-data-grid';
import { useState, useEffect, Fragment } from 'react';
import Spinner from '../../layout/Spinner';


const axios = require('axios').default;

export interface IListPageProps {
    configname:string
}

export interface IConfig  {
    name:string,
    getListDataUrl:string,
    pageTitle:string,
    spinnerMessage?:string
    columns:[any,any,any,any,any,any,any]
}

export interface IListPageProps  {
    configname:string
}

export const ListPage = (props:IListPageProps) => {

    const [data, setData] = useState( [] );
    const [config, setConfig] = useState<IConfig | null>(null);

    useEffect(() => {
 
        const fetchData = async (url:string) => {
          const result = await axios( url );
          setData(result.data.results);
        };

        import("../../nufrConfig/" + props.configname + "Config").then(c => {
            
            setConfig(c.default);
            if(config!=null) {
                console.log("config" + config);
                fetchData(config.getListDataUrl);
            }
        });

        return ;
        // eslint-disable-next-line
    }, [config]);
    
    if (config==null) {
        return <Spinner message={"Loading ..."} ></Spinner>;
    } else {    
        return (
            <Fragment>
                <div id={config.name+"pageTitle"} className="h1">{config.pageTitle}</div>
                <div id={ config.name+"datagrid"}>
                    { data.length > 0  ? 
                        <ReactDataGrid columns={config.columns} rows={data} /> 
                        :
                        <Spinner message={config.spinnerMessage || "Loading ..."} ></Spinner> 
                    }
                </div>
            </Fragment>

            ); 
    }
            
}

export default ListPage;
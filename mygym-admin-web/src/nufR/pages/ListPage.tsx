import ReactDataGrid from 'react-data-grid';
import { useState, useEffect, Fragment } from 'react';
import Spinner from '../../layout/Spinner';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';

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
                <div id={config.name+"pageTitle"} >
                    <Typography variant="h4" gutterBottom>
                    {config.pageTitle}
                    </Typography>
                </div>
                <Box height="100%" bgcolor="grey.300" mx={0.5} width={120} display="inline-block">
                <div id={ config.name+"datagrid"} className="grid-wrapper">
                    { data.length > 0  ? 
                        <ReactDataGrid columns={config.columns} rows={data} className="fill-grid" style={{ resize: 'both' }} /> 
                        :
                        <Spinner message={config.spinnerMessage || "Loading ..."} ></Spinner> 
                    }
                </div>
                </Box>
            </Fragment>

            ); 
    }
            
}

export default ListPage;
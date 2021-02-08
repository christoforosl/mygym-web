import ReactDataGrid from 'react-data-grid';
import React, { useState, useEffect } from 'react';
import Spinner from '../../layout/Spinner';

import Box from '@material-ui/core/Box';
import AddCircleIcon from '@material-ui/icons/AddCircle';
import Button from '@material-ui/core/Button';
import { useTranslation } from "react-i18next";
import { createStyles, makeStyles, Theme } from '@material-ui/core/styles';
import { useNUFRConfig } from '../Hooks';
import { defaultConfig } from './INUFRConfig';
import PageTitle from './PageTitle';


const axios = require('axios').default;

const useStyles = makeStyles((theme: Theme) =>
  createStyles({
    button: {
      margin: theme.spacing(1),
    },
  }),
);

export interface INUFRConfigNameProps {
    configname: string
}

export interface IModelObjectRecord {
    id:number,
    loadtime:number,
    dirty:boolean
}


export interface INUFRConfigNameProps {
    configname: string
}

export const IConfigContext = React.createContext(defaultConfig);

export const ListPage = (props: INUFRConfigNameProps) => {
    
    const { t } = useTranslation();
    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true);
    const configHookRes = useNUFRConfig( props.configname );
    const classes = useStyles();

    useEffect(() => {

        setLoading(true);
        const fetchData = async (url: string) => {
            const result = await axios(url);
            setData(result.data.results);
            setLoading(false);
        };
        
        if ( configHookRes.loading === false) {
            fetchData(configHookRes.config.getListAPIUrl());
        }
        return;
        // eslint-disable-next-line
    }, [configHookRes.loading]);
    
    
    if (loading || configHookRes.loading) {
        return <Spinner loading={loading || configHookRes.loading} message={"Loading ..."} ></Spinner>;

    } else {
        return (
            <IConfigContext.Provider value={configHookRes.config}>

                <PageTitle config={configHookRes.config}/>
                
                <Box height="100%" bgcolor="grey.50" mx={1} width={1} display="inline-block">
                    <Button
                        variant="contained"
                        color="primary"
                        size="large"
                        title= {t('button.addnew')}
                        className={classes.button}
                        startIcon={<AddCircleIcon></AddCircleIcon>}>
                        {t('button.addnew')}
                        </Button>

                        <div id={configHookRes.config.name + "datagrid"} className="grid-wrapper">
                            <ReactDataGrid columns={configHookRes.config.gridColumns} rows={data} className="fill-grid" style={{ resize: 'both' }} />
                        </div>

                        :
                        <Spinner loading={loading} message={configHookRes.config.spinnerMessage} ></Spinner>
                    
                </Box>
            </IConfigContext.Provider>

        );
    }

}

export default ListPage;
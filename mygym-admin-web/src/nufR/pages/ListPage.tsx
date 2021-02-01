import ReactDataGrid from 'react-data-grid';
import React, { useState, useEffect, Fragment } from 'react';
import Spinner from '../../layout/Spinner';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import AddCircleIcon from '@material-ui/icons/AddCircle';
import Button from '@material-ui/core/Button';
import { useTranslation } from "react-i18next";
import { createStyles, makeStyles, Theme } from '@material-ui/core/styles';
import EditPage from './EditPage';

const axios = require('axios').default;

const useStyles = makeStyles((theme: Theme) =>
  createStyles({
    button: {
      margin: theme.spacing(1),
    },
  }),
);

export interface IListPageProps {
    configname: string
}

export interface IModelObjectRecord {
    id:number,
    loadtime:number,
    dirty:boolean
}

export class IConfig {
    
    readonly apiRoot = process.env.REACT_APP_API_ROOT;

    /** key: must be unique and is the cononicalized name of the model object so we can access the api end points */
    key: string  = '';

    name: string = '';
    
    /** api end point to get records for lists of model objects */
    getListAPIUrl = () => {
        if(!this.key) {
            throw new Error('Key not set');
        }
        return this.apiRoot+'api/services/model/'+this.key +'-mongo-query';
    };

    /** api end point to get a signle record for this model object */
    getEditAPIUrl = (id:number): string => {
        return this.apiRoot+'api/services/model/'+this.key +'/'+id;
    };
    
    postSaveApiUrl = (record:IModelObjectRecord): string  => {
        return this.apiRoot+'api/services/model/'+record.id;
    };
    
    pageTitle: string = '';
    spinnerMessage: string = 'Loading ... Please wait';
    columns: [any, any, any, any, any, any, any] = [null,null,null,null,null,null,null];
}

export interface IListPageProps {
    configname: string
}

export const ListPage = (props: IListPageProps) => {
    const { t } = useTranslation();
    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true);
    const [config, setConfig] = useState<IConfig | null>(null);
    const classes = useStyles();

    useEffect(() => {
        setLoading(true);
        const fetchData = async (url: string) => {
            const result = await axios(url);
            setData(result.data.results);
            setLoading(false);
        };

        import("../../nufrConfig/" + props.configname + "Config").then(c => {
            setLoading(true);
            setConfig(c.default);
            if (config != null) {
                console.log("config" + config);
                fetchData(config.getListAPIUrl());
            }
        });

        return;
        // eslint-disable-next-line
    }, [config]);

   

    if (loading || !config) {
        return <Spinner loading={loading} message={"Loading ..."} ></Spinner>;
    } else {
        return (
            <Fragment>

                <div id={config.name + "pageTitle"} >
                    <Typography variant="h4" gutterBottom>
                        {config.pageTitle}
                    </Typography>
                </div>


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

                        <div id={config.name + "datagrid"} className="grid-wrapper">
                            <ReactDataGrid columns={config.columns} rows={data} className="fill-grid" style={{ resize: 'both' }} />
                        </div>

                        :
                        <Spinner loading={loading} message={config.spinnerMessage} ></Spinner>
                    
                </Box>
            </Fragment>

        );
    }

}

export default ListPage;
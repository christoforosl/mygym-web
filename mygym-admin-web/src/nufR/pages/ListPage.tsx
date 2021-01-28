import ReactDataGrid from 'react-data-grid';
import { useState, useEffect, Fragment } from 'react';
import Spinner from '../../layout/Spinner';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import AddCircleIcon from '@material-ui/icons/AddCircle';
import Button from '@material-ui/core/Button';
import { useTranslation } from "react-i18next";
import { createStyles, makeStyles, Theme } from '@material-ui/core/styles';

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

export interface IConfig {
    name: string,
    getListDataUrl: string,
    pageTitle: string,
    spinnerMessage?: string
    columns: [any, any, any, any, any, any, any]
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

            setConfig(c.default);
            if (config != null) {
                console.log("config" + config);
                fetchData(config.getListDataUrl);
            }
        });

        return;
        // eslint-disable-next-line
    }, [config]);

    if (loading || !config) {
        return <Spinner message={"Loading ..."} ></Spinner>;
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

                    {loading === false ?

                        <div id={config.name + "datagrid"} className="grid-wrapper">
                            <ReactDataGrid columns={config.columns} rows={data} className="fill-grid" style={{ resize: 'both' }} />
                        </div>

                        :
                        <Spinner message={config.spinnerMessage || "Loading ..."} ></Spinner>
                    }
                </Box>
            </Fragment>

        );
    }

}

export default ListPage;
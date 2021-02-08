import { Typography } from '@material-ui/core';
import React from 'react';
import { Trans } from 'react-i18next';
import { INUFRConfig } from './INUFRConfig';

function PageTitle(props: { config: INUFRConfig, labelKey?:string }) {
    
    
    return (
        <div id={props.config.name + "_pageTitle"} >
        <Typography variant="h4" gutterBottom>
            {props.config.pageTitle} { props.labelKey && (<Trans i18nKey={props.labelKey}></Trans>)  }
        </Typography>
        </div>
    );
}

export default PageTitle;
 
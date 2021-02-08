import { Typography } from '@material-ui/core';
import React from 'react';
import { INUFRConfig } from './INUFRConfig';

function PageTitle(props: { config: INUFRConfig }) {
    return (
        <div id={props.config.name + "_pageTitle"} >
        <Typography variant="h4" gutterBottom>
            {props.config.pageTitle}
        </Typography>
        </div>
    );
}

export default PageTitle;


import React from 'react';
import { Route } from 'react-router-dom';
import EditPage from './pages/EditPage';
import ListPage, { INUFRConfigNameProps } from './pages/ListPage';

export const NUFRRoute = (props: INUFRConfigNameProps) => {
    
    return (
        <>
        <Route path={`/${props.configname}/list`}><ListPage configname={props.configname} /></Route>
        <Route path={`/${props.configname}/add`} configname={props.configname} component={EditPage} />
        <Route path={`/${props.configname}/edit/:id`} configname={props.configname} component={EditPage} />
        </>
    );
}

export default NUFRRoute;


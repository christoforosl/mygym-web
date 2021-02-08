

import React from 'react';
import { Route } from 'react-router-dom';
import EditPage from './pages/EditPage';
import ListPage, { INUFRConfigNameProps } from './pages/ListPage';

export const NUFRRoute = (props: INUFRConfigNameProps) => {
    
    return (
        <>
        <Route path={`/${props.configname}/list`}><ListPage configname={props.configname} /></Route>
        <Route path={`/${props.configname}/add`}><EditPage configname={props.configname} mode="add" /></Route>
        <Route path={`/${props.configname}/edit/:id`}><EditPage configname={props.configname} mode="edit"  /></Route>
        </>
    );
}

export default NUFRRoute;


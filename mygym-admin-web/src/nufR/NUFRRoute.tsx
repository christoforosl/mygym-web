
import React from 'react';
import { Route } from 'react-router-dom';
import EditPage from './pages/EditPage';

function NUFRRoute() {
    return (
        <>        
        <Route path='/exercises/add' configname="Exercise" component={EditPage} />
        <Route path='/exercises/edit/:id' configname="Exercise" component={EditPage} />
        </>
    );
}

export default NUFRRoute;


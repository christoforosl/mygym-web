import React from "react";

import "./styles/App.css";
import "./styles/GridStyles.css";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import Header from "./pages/Header";

import HomePage from "./pages/HomePage";
import {I18nextProvider} from "react-i18next";
import i18n from "./i18n"
import Container from '@material-ui/core/Container';
import NUFRRoute from "./nufR/NUFRRoute";
import { SnackbarProvider } from 'notistack';

function App() {
  
  return (
    <React.StrictMode>
      <SnackbarProvider maxSnack={3} 
                        preventDuplicate  
                        anchorOrigin={{
                          vertical: 'top',
                          horizontal: 'center'}}>
      
      <I18nextProvider i18n={i18n}>
        <Router>
        <Container maxWidth="xl" disableGutters={true}>
            
              <Header />
              <Switch>
                
                <NUFRRoute configname="ExerciseDefinition" />
                <NUFRRoute configname="Workout" />
                <NUFRRoute configname="Users" />

                <Route path='/'>
                  <HomePage />
                </Route>
              </Switch>
            
          </Container>
        </Router>
      </I18nextProvider>
      </SnackbarProvider>
    </React.StrictMode>
  );
}

export default App;

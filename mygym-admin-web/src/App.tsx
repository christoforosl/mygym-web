import React from "react";

import "./styles/App.css";
import "./styles/GridStyles.css";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import Header from "./pages/Header";
import ListPage from "./nufR/pages/ListPage"
import HomePage from "./pages/HomePage";
import {I18nextProvider} from "react-i18next";
import i18n from "./i18n"
import Container from '@material-ui/core/Container';

function App() {
  

  return (
    <React.StrictMode>
      <I18nextProvider i18n={i18n}>
        <Router>
        <Container maxWidth="xl" disableGutters={true}>
            
              <Header />
              <Switch>
                <Route path='/exercises'>
                  <ListPage configname="exercise" />
                </Route>
                <Route path='/'>
                  <HomePage />
                </Route>
              </Switch>
            
          </Container>
        </Router>
      </I18nextProvider>
    </React.StrictMode>
  );
}

export default App;

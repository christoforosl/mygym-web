import React, { Fragment } from "react";

import "./App.css";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

import Header from "./pages/Header";
import ExercisesListPage from "./pages/ExercisesListPage";
import HomePage from "./pages/HomePage";
import {I18nextProvider} from "react-i18next";
import i18n from "./i18n"

function App() {
  return (
    <React.StrictMode>
      <I18nextProvider i18n={i18n}>
        <Router>
          <Fragment>
            <section>
              <Header />
              <Switch>
                <Route path='/exercises'>
                  <ExercisesListPage />
                </Route>
                <Route path='/'>
                  <HomePage />
                </Route>
              </Switch>
            </section>
          </Fragment>
        </Router>
      </I18nextProvider>
    </React.StrictMode>
  );
}

export default App;

import React, { Fragment } from "react";

import "./styles/App.css";
import "./styles/GridStyles.css";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

import Header from "./pages/Header";
import ListPage from "./nufR/pages/ListPage"
import HomePage from "./pages/HomePage";
import {I18nextProvider} from "react-i18next";
import i18n from "./i18n"
import common_en from "./translations/en/common.json";

function App() {

  console.log("common_en:" + JSON.stringify(common_el));

  return (
    <React.StrictMode>
      <I18nextProvider i18n={i18n}>
        <Router>
          <Fragment>
            <section>
              <Header />
              <Switch>
                <Route path='/exercises'>
                  <ListPage configname="exercise" />
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

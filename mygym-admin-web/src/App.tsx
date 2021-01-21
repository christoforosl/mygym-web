import React, {Fragment} from "react";

import "./App.css";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

import Header from "./pages/Header";
import ExercisesListPage from "./pages/ExercisesListPage";
import HomePage from "./pages/HomePage";
import Navbar from "./pages/Navbar";

function App() {
  return (
    <Router>
      <Fragment>
              <Navbar />
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
  );
}

export default App;

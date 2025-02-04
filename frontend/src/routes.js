import React from 'react';
import { Route, Switch } from 'react-router-dom';
import Dashboard from './pages/Dashboard';
import Login from './pages/Login';
import PatientReport from './pages/PatientReport';
import Profile from './pages/Profile';

const Routes = () => (
  <Switch>
    <Route exact path="/" component={Dashboard} />
    <Route path="/login" component={Login} />
    <Route path="/report/:id" component={PatientReport} />
    <Route path="/profile" component={Profile} />
  </Switch>
);

export default Routes;

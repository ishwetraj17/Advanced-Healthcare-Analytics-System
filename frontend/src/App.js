import React, { useContext } from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import { AuthContext } from './context/AuthContext';
import Dashboard from './pages/Dashboard';
import Login from './pages/Login';
import PatientReport from './pages/PatientReport';
import Profile from './pages/Profile';
import Header from './components/Header';

const App = () => {
  const { isAuthenticated } = useContext(AuthContext);

  return (
    <Router>
      <Header />
      <Switch>
        <Route path="/" exact component={Dashboard} />
        <Route path="/login" component={Login} />
        <Route path="/report/:id" component={PatientReport} />
        <Route path="/profile" component={Profile} />
        {!isAuthenticated && <Redirect to="/login" />}
      </Switch>
    </Router>
  );
};

export default App;

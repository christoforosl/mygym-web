import React, { Fragment, useContext, useEffect } from "react";
import { Link } from "react-router-dom";
// import AuthContext from '../../context/auth/authContext';
// import ContactContext from '../../context/contact/contactContext';

const Navbar = () => {
  //const authContext = useContext(AuthContext);
  //const contactContext = useContext(ContactContext);

  const isAuthenticated = true;
  const user: IUser = { name: "Christoforos" };
  const onLogout = function () {};

  const authLinks = (
    <Fragment>
      <li>
        
        <Link to='/home'>Home</Link>
      </li>
      <li>
        <Link to='/exercises'>Exercises</Link>
      </li>
      <li>
        <Link to='/workouts'>Workouts</Link>
      </li>
      <li>
        <a onClick={onLogout} href='#!'>
        User: {user && user.name}{" | "}
          <i className='fas fa-sign-out-alt' />{" "}
          <span className='hide-sm'>Logout</span>
        </a>
      </li>
    </Fragment>
  );

  const guestLinks = (
    <Fragment>
      <li>
        <Link to='/register'>Register</Link>
      </li>
      <li>
        <Link to='/login'>Login</Link>
      </li>
    </Fragment>
  );

  return (
    <div className='navbar bg-primary'>
      <h1>
        <Link to='/'>
          <i className={appProperties.icon} /> {appProperties.title}
        </Link>
      </h1>
      <ul>{isAuthenticated ? authLinks : guestLinks}</ul>
    </div>
  );
};

interface IAppProperties {
  title: string;
  icon: string;
}
interface IUser {
  name: string;
}

const appProperties: IAppProperties = {
  title: "MyGym-X Administration",
  icon: "fas fa-heartbeat",
};

export default Navbar;

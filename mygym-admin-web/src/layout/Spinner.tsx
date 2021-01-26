import React, { Fragment } from 'react';
import spinner from './spinner.gif';

interface ISpinnerArgs {
  message:string,
  altText?:string
}

export default function Spinner(  {message , altText } :ISpinnerArgs) {

  return (<div style={{ width: '200px', margin: 'auto', display: 'block' }}>
           {message}
          <img src={spinner} style={{ width: '200px', margin: 'auto', display: 'block' }} alt={ altText ? altText : "Loading..." } />
        </div>);

}

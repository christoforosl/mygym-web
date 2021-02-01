import React from 'react';
import LinearProgress from '@material-ui/core/LinearProgress';
import { Typography } from '@material-ui/core';
import { makeStyles, createStyles, Theme } from '@material-ui/core/styles';

interface ISpinnerArgs {
  message: string,
  loading?: boolean
}

const useStyles = makeStyles((theme: Theme) =>
  createStyles({
    root: {
      display: 'flex',
      flexDirection: 'column',
      alignItems: 'center',
      marginTop: theme.spacing(5),
      marginBottom: theme.spacing(5),
      textAlign:'center'

    },
    placeholder: {
      height: 50,
    },
  }),
);

const useProgressStyles = makeStyles((theme: Theme) =>
  createStyles({
    root: {
      width: '80%',
      '& > * + *': {
        marginTop: theme.spacing(2),
      },
    },
  }),
);

export default function Spinner({ message, loading }: ISpinnerArgs) {
  const classes = useStyles();
  const progressClass = useProgressStyles();
  
  const getLoading = () => {
    return loading === undefined ? true : loading; 
  } 
  //console.log("loading:" + getLoading() );
  if(getLoading()===false)return <></>

  return (
    <>
      <div id="spinner" className={classes.root}>
        <div className={progressClass.root}>
          <LinearProgress color="primary" />
           <Typography variant="h6" color='error' gutterBottom id="spinnerMessage">{message || "Loading ..."}</Typography> 
        </div>
      </div>

    </>
  );
}




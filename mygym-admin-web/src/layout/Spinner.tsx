import React from 'react';
import LinearProgress from '@material-ui/core/LinearProgress';
import { Typography } from '@material-ui/core';
import { makeStyles, createStyles, Theme } from '@material-ui/core/styles';

interface ISpinnerArgs {
  message: string,
  altText?: string
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

export default function Spinner({ message, altText }: ISpinnerArgs) {
  const classes = useStyles();
  const progressClass = useProgressStyles();

  return (
    <>
      <div className={classes.root}>
        <div className={progressClass.root}>
          <LinearProgress color="primary" />
           
           <Typography variant="h6" color='error' gutterBottom>{message}</Typography> 
        </div>
      </div>

    </>
  );
}




import React, { Fragment, useEffect } from 'react';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import Slide from '@material-ui/core/Slide';
import { TransitionProps } from '@material-ui/core/transitions';
import { withRouter } from 'react-router';
import { RouteComponentProps } from 'react-router-dom';


const Transition = React.forwardRef(function Transition(
  props: TransitionProps & { children?: React.ReactElement<any, any> },
  ref: React.Ref<unknown>,
) {
  return <Slide direction="up" ref={ref} {...props} />;
});

export interface IDialogProps {
    
    isOpen:boolean, 
    messageTitle?:string,
    messageTitleLabelKey?:string,
    message?:string,
    messageLabelKey?:string,
    noMessage?:string,
    yesMessage?:string,
    noCallback?:() => void,
    yesCallback?:() => void

}


const NUFRAlertDialog = (props:RouteComponentProps ) => {

  const [open, setOpen] = React.useState(false);

    const handleClose = () => {
        setOpen(false);
    };

    useEffect(() => {
        if (! props.noCallback ) {
            props.noCallback = handleClose;
        }
        if (! props.yesCallback ) {
            props.yesCallback = handleClose;
        }

        setOpen(props.isOpen);
        return;
        // eslint-disable-next-line
    }, [props.isOpen]);
    

    return (
    <Fragment>    
      <Dialog
        open={open}
        TransitionComponent={Transition}
        keepMounted
        onClose={handleClose}
        aria-labelledby="alert-dialog-slide-title"
        aria-describedby="alert-dialog-slide-description"
      >
        <DialogTitle id="alert-dialog-slide-title">{props.messageTitle}</DialogTitle>
        <DialogContent>
          <DialogContentText id="alert-dialog-slide-description">
                {props.message}
          </DialogContentText>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose} color="primary">
            {props.noMessage}
          </Button>
          <Button onClick={handleClose} color="primary">
          {props.yesMessage}
          </Button>
        </DialogActions>
      </Dialog>
    </Fragment>
  );
}

export default withRouter(NUFRAlertDialog);

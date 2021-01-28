import {Fragment} from 'react';
import IconButton from '@material-ui/core/IconButton';
import DeleteIcon from '@material-ui/icons/Delete';
import EditIcon from '@material-ui/icons/Edit';

export interface IDateProps {
  dateVal: string;
}

export interface IDProps {
  id: string;
}

export const EditButtonsFormatter = ({ id }: IDProps ) => {
  return <Fragment>
          <IconButton id={"btnEdit_" +id } size="small" aria-label="edit"color="primary"><EditIcon /></IconButton> 
          <IconButton id={"btnDelete_" +id } size="small" aria-label="delete" color="secondary"><DeleteIcon /></IconButton>
          </Fragment>;
};



export function DateFormatter({ dateVal }: IDateProps) {
    if(!dateVal)return <></>;

    const dateNumericValue = parseInt(dateVal);
    const formatted = new Intl.DateTimeFormat("en-GB", {
        year: "numeric",
        month: "2-digit",
        day: "2-digit"
      }).format(new Date(dateNumericValue));

    return <>{formatted}</>;
};

export function DateTimeFormatter({ dateVal }: IDateProps) {
    if(!dateVal)return <></>;

    const dateNumericValue = parseInt(dateVal);
    const formatted = new Intl.DateTimeFormat("en-GB", {
        year: "numeric",
        month: "2-digit",
        day: "2-digit",
        hour: 'numeric', minute: 'numeric', second: 'numeric',
        hour12: false,
      }).format(new Date(dateNumericValue));

    return <>{formatted}</>;
};

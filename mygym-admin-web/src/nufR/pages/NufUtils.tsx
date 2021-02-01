import React, {Fragment} from 'react';
import IconButton from '@material-ui/core/IconButton';
import DeleteIcon from '@material-ui/icons/Delete';
import EditIcon from '@material-ui/icons/Edit';
import EditPage from './EditPage';

export interface IDateProps {
  dateVal: string;
}

export interface IDProps {
  id: string;
}

const editRow = (id:number) => {
  <>
      <h2>Edit</h2>
      <EditPage config={config!} id={id}/>
  </>

};

export const EditButtonsFormatter = ({ id }: IDProps ) => {
  return <Fragment>
          <IconButton id={"btnEdit_" +id } size="small" aria-label="edit"color="primary"  
                onClick={() => {
                            editRow(id)
                        }} ><EditIcon /></IconButton> 
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

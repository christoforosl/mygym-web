import React from 'react';
import IconButton from '@material-ui/core/IconButton';
import DeleteIcon from '@material-ui/icons/Delete';
import EditIcon from '@material-ui/icons/Edit';
import { Link } from 'react-router-dom';
import { IConfigContext } from './ListPage';


export interface IDateProps {
  dateVal: string;
}

export interface IDProps {
  id: string;
}

export const EditButtonsFormatter = ({ id }: IDProps ) => {

  return (
    <>
      <IConfigContext.Consumer>
         {value => 
            <>
            <Link id={"btnEdit_" +id } to={`${value.key}/edit/${id}`} ><IconButton size="small" color="primary"><EditIcon /></IconButton></Link>
            <Link id={"btnDelete_" +id } to={`${value.key}/delete/${id}`} ><IconButton size="small" color="secondary"><DeleteIcon /></IconButton></Link>
            </>
         }
      </IConfigContext.Consumer>
    </>
  );
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

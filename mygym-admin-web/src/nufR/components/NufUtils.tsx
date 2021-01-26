import {Fragment} from 'react';

interface IDateProps {
  dateVal: string;
}

interface IDProps {
  id: string;
}


export const EditButtonsFormatter = ({ id }: IDProps ) => {
  return <Fragment><i id={id} className="far fa-trash-alt"></i> &nbsp; <i id={id} className="far fa-edit"></i> </Fragment>
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

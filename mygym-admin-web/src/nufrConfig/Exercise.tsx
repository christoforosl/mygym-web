
import appVars from "../globals/AppVars.json"
import {IConfig} from '../nufR/pages/ListPage';
import {DateTimeFormatter, EditButtonsFormatter} from '../nufR/pages/NufUtils';

export const config:IConfig = {
    name:"Exercise",
    pageTitle:"Exercise List",
    getListDataUrl : process.env.REACT_APP_API_ROOT+appVars.apiEndPoints.getExerciseList.url,
    columns: [
        { key: 'exerciseDefinitionId', name: 'ID', width: 1 },
        { key: 'editButtons', name: '', width: 1, formatter(props:any) { return <EditButtonsFormatter id={props.row.id}></EditButtonsFormatter>}},
        { key: 'name', name: 'Name' },
        { key: 'description', name: 'Description' },
        { key: 'equipment', name: 'Equipment' },
        { key: 'createDate', name: 'Created' , formatter(props:any) {
                return <DateTimeFormatter dateVal={props.row.createDate} />;
            }},
        { key: 'updateDate', name: 'Updated' , formatter(props:any) {
                return <DateTimeFormatter dateVal={props.row.createDate} />;
            }}
        
         ]


};


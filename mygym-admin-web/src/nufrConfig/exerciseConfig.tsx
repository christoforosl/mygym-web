
import {IConfig} from '../nufR/pages/ListPage';
import {DateTimeFormatter, EditButtonsFormatter} from '../nufR/pages/NufUtils';

class Config extends IConfig {

    constructor() {
        super();
        this.key = "exercisedefinition";
        this.name = "Exercise"; // must match name of file, case sensistive!!!
        this.pageTitle ="Exercise List";
        
        this.columns = [
            { key: 'exerciseDefinitionId', name: 'ID', width: 1 },
            { key: 'editButtons', name: '', width: 1, formatter(props:any) { return <EditButtonsFormatter configname={this.name} id={props.row.id}></EditButtonsFormatter>}},
            { key: 'name', name: 'Name' },
            { key: 'description', name: 'Description' },
            { key: 'equipment', name: 'Equipment' },
            { key: 'createDate', name: 'Created' , formatter(props:any) {
                    return <DateTimeFormatter dateVal={props.row.createDate} />;
                }},
            { key: 'updateDate', name: 'Updated' , formatter(props:any) {
                    return <DateTimeFormatter dateVal={props.row.createDate} />;
                }}
            
             ];
    }
  


};
const myConfig = new Config();
export default myConfig;
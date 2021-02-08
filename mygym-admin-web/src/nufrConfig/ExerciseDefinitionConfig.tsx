

import { INUFRConfig } from "../nufR/pages/INUFRConfig";
import {DateTimeFormatter, EditButtonsFormatter} from '../nufR/pages/NufUtils';

class NUFRConfig extends INUFRConfig {

    constructor() {
        super();
        this.key = "exercisedefinition"; // api route
        this.name = "ExerciseDefinition"; // must match name of file, case sensistive!!!
        this.pageTitle ="Exercise List";
        
        this.columns = [
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
            
             ];
    }
  


};
const myConfig = new NUFRConfig();
export default myConfig;
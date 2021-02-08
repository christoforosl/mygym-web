import { INUFRConfig } from "../nufR/pages/INUFRConfig";
import {DateTimeFormatter, EditButtonsFormatter} from '../nufR/pages/NufUtils';
import i18next from "i18next";

class NUFRConfig extends INUFRConfig {
    
    constructor() {

        super();
        
        this.key = "exercisedefinition"; // api route
        this.name = "ExerciseDefinition"; // must match name of file, case sensistive!!!
        this.pageTitle ="Exercise";
        
        this.gridColumns = [
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

        this.formSchema = {
                
                "type": "object",
                "required": [
                  "name",
                  "equipmentId",
                  "bodyPartIds"
                ],
                "properties": {
                  "name": {
                    "type": "string",
                    "title":  i18next.t(this.key+".name")
                  },
                  "description": {
                    "type": "string",
                    "title":  i18next.t(this.key+".description")
                  },
                  "equipmentId": {
                    type: "number",
                    enum: [1, 2, 3, 4],
                    enumNames: ["Body Part Exercise, no Equipment Needed", "Dumbells", "Bar", "Latex Band"],
                    "title":  i18next.t(this.key+".equipment")
                  },
                  "bodyPartIds": {
                    type: "array",
                    items: {
                        
                        enum: [1, 2, 3, 4,5, 11],
                        enumNames: ["Abs", "Forearms", "Tricepts", "Legs","Core","Chest"]
                      },
                    uniqueItems: true,
                    "title":  i18next.t(this.key+".bodyparts")
                  },
                  "typeIds": {
                    type: "array",
                    items: {
                        
                        enum: [1, 2, 3],
                        enumNames: ["Exercise", "Warmup", "Stretch"]
                    },
                    uniqueItems: true,
                    "title":  i18next.t(this.key+".type")
                  }
                }
              }
             
    }
  


};
const myConfig = new NUFRConfig();
export default myConfig;
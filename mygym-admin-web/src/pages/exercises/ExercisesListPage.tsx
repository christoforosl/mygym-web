import useSWR from 'swr'
import config from "../../globals/AppVars.json"
import APICallerUtils from "../../nufR/APICallerUtils"

export default function ExercisesListPage() {
    
    const url:string = config.apiEndPoints.getExerciseList.url;

    const { data, error, mutate, isValidating } = useSWR( url, APICallerUtils.get(url));
        

    return <>exercise list</>;
    
}

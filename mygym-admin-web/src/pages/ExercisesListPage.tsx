
import useSWR from 'swr'
import axios from 'axios'
import config from "../globals/AppVars.json"


export default function ExercisesListPage() {
    
    const url = config.apiEndPoints.getExerciseList.url;

    const fetcher = url => axios.get(url).then(res => res.data)
    const { data, error } = useSWR('/api/user/123', fetcher)
    return <>exercise list</>;

}

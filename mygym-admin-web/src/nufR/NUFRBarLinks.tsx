import { Button } from '@material-ui/core'
import React from 'react'
import { Link } from 'react-router-dom'

function NUFRBarLinks() {

    return (
        <>
        
        <Button color="inherit" component={Link} to={`/ExerciseDefinition/list`}>
            Exercises
        </Button>
        |
        <Button color="inherit" component={Link} to={`/WorkoutDefinition/list`}>
            Workouts
        </Button>
        |
       
        </>
    )
}



export default NUFRBarLinks


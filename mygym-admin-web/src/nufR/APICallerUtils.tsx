import { AxiosError } from 'axios';

const axios = require('axios').default;

/** object returned by all our api calls */
export interface apiResults {
    error:string,
    results:any,
    status:string,
    debugInfo:string,
    numResults:number,
    hostname:string
}


const APICallerUtils = {
    get: (url:string) => {
        return axios.get(url)
        .then( (response: any) => {
            // handle success
            if (response.status==='ERROR') {
                throw response.error;
            }
            //console.log( response.data );
            const ret: apiResults  = response.data;
            return ret.results;

        })
        .catch( (error: AxiosError) => {
            // handle error
            console.log(error);
            throw error;

        })
        .then(() => {
        // always executed
        });

    } 
   
}

export default APICallerUtils;

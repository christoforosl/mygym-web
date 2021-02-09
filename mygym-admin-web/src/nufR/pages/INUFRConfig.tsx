
export class INUFRConfig {

    readonly apiRoot = process.env.REACT_APP_API_ROOT;

    /** key: must be unique and is the cononicalized name of the model object so we can access the api end points */
    key: string = '';

    /** must match name of file that the configuation is saved at */
    name: string = '';

    /** api end point to get records for lists of model objects */
    getListAPIUrl = () => {
        if (!this.key) {
            throw new Error('Key not set');
        }
        return this.apiRoot + 'api/services/model/' + this.key + '-mongo-query';
    };

    /** api end point to get a signle record for this model object */
    getEditAPIUrl = (id: string): string => {
        if (!this.key) {
            throw new Error('Key not set');
        }
        return this.apiRoot + 'api/services/model/' + this.key + '/' + id;
    };

    getSaveApiUrl = (): string => {
        if (!this.key) {
            throw new Error('Key not set');
        }
        return this.apiRoot + 'api/services/model/' + this.key;
    };

    pageTitle: string = '';
    spinnerMessage: string = 'Loading ... Please wait';
    gridColumns: [any, any, any, any, any, any, any] = [null, null, null, null, null, null, null];

    formSchema:object = {};
}

export const defaultConfig = new INUFRConfig();

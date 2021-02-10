import Ajv from 'ajv';
import JSONSchemaBridge from 'uniforms-bridge-json-schema';


const ajv = new Ajv({ allErrors: true, useDefaults: true, $data: true });


export function createValidator(schema: object) {
  //ajv.addKeyword('uniforms');
  const validator = ajv.compile(schema);
  console.log("createValidator compiled" + validator)
  return (model: object) => {
    validator(model);
    return validator.errors?.length ? { details: validator.errors } : null;
  };
}
export default function createBride(schema: object) {
  const schemaValidator = createValidator(schema);
  console.log("schemaValidator created" + schemaValidator)
  console.log("schemaValidator schema:" + JSON.stringify( schema));

  return new JSONSchemaBridge(schema, schemaValidator);

}


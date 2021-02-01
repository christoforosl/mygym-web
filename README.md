# React Sample Application

This is a react sample applcation, to be used for development of react framework. How to setup:

1.  Create a mysql database or use an existing one. Import script DBDump20210120.sql. The jdbc connection string is embedded encrypted in property jdbcurl-DEV in properties file .\mygym-web\mygym-services\src\main\resources\generic-api-server.properties

2. Run project mygym-services. This is a stand alone, command line java application that loads a jetty server.
3. When the mygym-services application runs, the api end points are exposed.
The REST api end points are one for each model object that exists in the package specified in modelPackageForRestAPI. 
Look at file `.\mygym-web\mygym-services\src\main\resources\nufModel.properties`
In this file, you will see property 
```
modelPackageForRestAPI=com.mygym.model
```
For each model object the following end points are exposed:
  1. POST "model/{modelObjectKey}" Save model object. Updates or Inserts, based on the id value
  2. GET "model/{modelObjectKey}-lastUpdate" returns a date with the latest update date of any records in the table
  3. GET "model/{modelObjectKey}/{Id}  delete a model object by id
  4. DELETE "model/{modelObjectKey}/{Id}" delete a model object by id
  5. GET and POST "model/{modelObjectKey}-mongo-query" Support mongo style queries as per https://docs.mongodb.com/v3.2/reference/operator/query/ and http://docs.mlab.com/data-api/#list-documents

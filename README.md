# cf-data-init

In some cases an application may require the database its working with to contain specific data or stored procedures. Without these the application will not be able to operate, or may not even start.

## Data Bases in Cloud Environments

The challenge in Cloud Environments is a database may be created on demand for the application. Everything about this database will be determined at creation time and passed to the application at deployment time allowing the application to bind to the database. The database creation generally is done by a third party service making any sort of custom database tuning tedious. A better pattern is to have the application configure the DB in the way it needs at start up.

## Having The Application Configure The Database

This samples shows how to have a Spring Boot application configure the database on start up. In this case the database is created by a PCF Service Broker.

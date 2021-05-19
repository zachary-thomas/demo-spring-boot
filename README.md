# demo-spring-boot

From youtube tutorial here: https://www.youtube.com/watch?v=9SGDpanrc8U by Amigoscode

This demo is a simple API with CRUD operations and basic service logic.

When compiling the jar, you can run it via the following command:

`java -jar .\demo-0.0.1-SNAPSHOT.jar --server.port=8081`

Change the port number for each instance.

You will need to install PostgreSQL and have a database named 'student' if you wish to run locally.

If you're running from windows, add the bin folder to your path, then run this command:

`psql -Upostgres`

The password you made on setup is the password to this user.

`CREATE DATABASE student;`

Run this to make sure the postgres user has all available privileges:

`GRANT ALL PRIVILEGES ON DATABASE "student" TO postgres;`

The application will automatically create the 'student' table once the database has been created.
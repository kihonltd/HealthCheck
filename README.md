# A simple server health check application for use in environments with no monitoring solution 

This Spring Boot command line application will attempt test connectivity to all servers configured in `application-{profile}.yml`.  
The application will print the results of the connection tests to the console.
 
### Environment variables
A number of options can be configured using environment variables (e.g. -DRETRY=10)

- LOGLEVEL (default:INFO)
- RETRY (default:3) The number of times to retry a failed connection
- TIMEOUT (default:10) The number of seconds to wait before a connection attempt times out

### How to run
Maven: `mvn spring-boot:run`   
Jar: `java -DRETRY=10 -DLOGLEVEL="DEBUG" -jar target/HealthCheck-0.0.1-SNAPSHOT.jar`

### Default profile
The default profile is `dev`.  The application will test ports 80 and 8080 on localhost.


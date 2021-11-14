# A simple server health check application for use in environments with no monitoring solution 

This springboot command line application will attempt test connectivity to all servers configured in `application.yml`
The application will print the results of the connection tests to the console.
 
### Environment variables
A number of options can be configured using environment variables (e.g. -DRETRY=10)

- LOGLEVEL (default:INFO)
- RETRY (default:3) The number of times to retry a failed connection
- TIMEOUT (default:10) The number of seconds to wait before a connection attempt times out


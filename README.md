# honeypotservice

1. Just a basic service using springboot which handles all / and /* get request by responding "Notfound" string.
2. Doesn't handle any other request( ex, put, post, etc)
3. For simplicity the service layer is ignored, and response is sent from controller. 

How to build and run in docker:
1. Download the repo, and run " docker build -t honeypotservice ." command
2. This should build the image. 
3. Run the below command "docker run -p 8080:8080 <image id >". 
  Note: Image id can be obtained from running "docker images" command. The id corresponding to the honeypotservice image is the image id
  
How to Test:
 1. Bring up the service by running the docker run command. 
 2. use "curl http://localhost:8080" to hit the end point. 
  
  
Potential issues:
  1. sometimes the port may not be open in the host terminal. If thats the case, the serivce wont receive any request from client & vice-versa. Please open the port by running the following command 
    For linux:
      1. sudo ufw allow 8080
    For windows:
      1. Open windows firewall and configure port 8080 to allow traffic. 
  
  
How the service works:
  1. Upon running the service, the service listens to request at 8080 port. 
  2. The controller handles all the get request and responds a stream of "NotFound string for every 4 secs.
  3. This will hog the client as the client continues to listen to the stream of "NotFound" string before sending other requests. 
  
Limitations:
  1. Since the request handling thread sleeps for every 4 secs, a thread is getting locked on to the client, therefore is unavailable to handle other requests. 
  2. The maximum number of concurrent request is limited by the no.of.threads configured in the tomcat server( default being 200 ).
  

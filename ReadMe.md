# project to Shorten url links
### Technology stack used
1. JAVA - SpringBoot
1. Maven
1. MySQL database

### NOTE
The project contains two packages, question1 and question2. Each package contains the attempted solution for each question respectively.
### How to run the API,Question1
1. Update the ```application properties``` file on the ```resources``` folder to suite your environment
1. Run ```mvn install``` to set up the project dependencies 
1. Run the main class ```InfamaInterviewTestApplication.java```, this should run smoothly if all dependencies are setup correctly
### Rest Server up and running?

##### Shorten url
* Endpoint [/shorten](/shorten)
* Type ```POST```
* Expects ```JSON```
* Sample request
    ```json
    {
        "url":"http://www.example.com"
    }
    ```
* Expected success Response (code 200)
    ```text
       <base url>/{code}
      e.g http:127.0.0.1:8080/bAfrE
    ```
* Any Error will be indicated by the normal error codes
   
  ```OR```
  ```Any other html response code other than 200```
  
  ### What happens
  > when the shortened url is accessed, the system retrieves the original url and redirects the user to the original url
  

  Enjoy :)

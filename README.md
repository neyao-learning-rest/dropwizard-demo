About this project
-----------


How to build
-----------
mvn package


How to run
-----------

**In dev enviroment***
    cd <project>
    java -jar target/dropwizard-demo-1.0-SNAPSHOT.jar server target\class\datacenter-api.yml

Then just open your browser and access http://localhost:8080£¬ belowing is all the urls:
- http://localhost:8080/weixin
- http://localhost:8080/weixin?name=foo  
  use a parameter that will be shown in response body later

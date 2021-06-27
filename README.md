# camunda-multi-tenancy
Camunda Multi-Tenancy with Spring Boot and Postgres
<p>How Multi-Tenancy works? </p>
Deployment with specifying the tenant identifier via Deployment Descriptor </p>
Create processes.xml file in src/main/resouces/META-INF folder which is Deployment Descriptor. Since the descriptor can contain multiple process-archives, the tenant identifier can be set on each process-archive as tenantId attribute. </p>
<img src="docs\processes.png"> 
Start process Instance </p>
How starting process instance looks in code: </p>
<img src="docs\service.png"> 
  ProcessMap class contains map with schemas names and their's tenant id's. This data should be stored in database. </p>
  Schemas  </p>
  Schemas contain only one service task for example. </p>
  <img src="docs\balance_bpmn.png"> 
  Service Task invokes Java Delegates where main logic is located. </p>
  Class implementation: </p>
  <img src="docs\implementation.png"> 
  How to start this application? </p>
  1) Clone this project </p>
  2) Enter the project folder </p>
  3) Type mvn spring-boot:run </p>
  Application starts at localhost:8080. In database schemas would be deployed: </p>
  <img src="docs\deployment_db.png"> 
  How to check that the application works? </p>
  Use REST APi POST http://localhost:8080/process/start/Limit. Rest returns process instance execution id. In log you will see: execution of limit delegate...</p>
<br>Links:</br>
https://github.com/camunda/camunda-bpm-examples/tree/master/multi-tenancy/tenant-identifier-shared
https://docs.camunda.org/manual/7.15/user-guide/process-engine/multi-tenancy/
https://assets.ctfassets.net/vpidbgnakfvf/6qPAgbht0kyc2mIe2mcosC/13d6594affb6241b2714edebc73b421f/Multi-tenancy.pdf

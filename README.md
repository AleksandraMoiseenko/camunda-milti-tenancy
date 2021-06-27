# camunda-multi-tenancy
Camunda Multi-Tenancy with Spring Boot and Postgres
<p>How Multi-Tenancy works? Deployment with specifying the tenant identifier via Deployment Descriptor Create processes.xml file in src/main/resouces folder which is Deployment Descriptor. Since the descriptor can contain multiple process-archives, the tenant identifier can be set on each process-archive as tenantId attribute. <process-application  xmlns=&quot;http://www.camunda.org/schema/1.0/ProcessApplication&quot;  xmlns:xsi=&quot;http://www.w3.org/2001/XMLSchema-instance&quot;></p>

<p> <process-archive name=&quot;tenant1-archive&quot; tenantId=&quot;tenant1&quot;>  <process-engine>default</process-engine>  <properties>  <property name=&quot;resourceRootPath&quot;>classpath:processes/tenant1/</property></p>

<p> <property name=&quot;isDeleteUponUndeploy&quot;>false</property>  <property name=&quot;isScanForProcessDefinitions&quot;>true</property>  </properties>  </process-archive></p>

<p> <process-archive name=&quot;tenant2-archive&quot; tenantId=&quot;tenant2&quot;>  <process-engine>default</process-engine>  <properties>  <property name=&quot;resourceRootPath&quot;>classpath:processes/tenant2/</property></p>

<p> <property name=&quot;isDeleteUponUndeploy&quot;>false</property>  <property name=&quot;isScanForProcessDefinitions&quot;>true</property>  </properties>  </process-archive></p>

<p></process-application> Start process Instance How starting process instance looks in code: public class CamundaServiceImpl implements CamundaService {</p>

<p> RuntimeService runtimeService;</p>

<p> public CamundaServiceImpl(@Autowired ProcessEngine processEngine) {  this.runtimeService = processEngine.getRuntimeService();  }</p>

<p> @Override  public String start(String processKey) {  String tenantId = new ProcessMap()  .getProcessNameToTenant().get(processKey);  ProcessInstance instance = runtimeService  .createProcessInstanceByKey(processKey)  .processDefinitionTenantId(tenantId)  .caseInstanceId(tenantId)  .execute();  return instance.getProcessInstanceId();  } } ProcessMap class contains map with schemas names and their's tenant id's. This data should be stored in database. Schemas  Schemas contain only one service task for example. Service Task invokes Java Delegates where main logic is located. Class implementation: How to start this application? 1) Clone this project 2) Enter the project folder 3) Type mvn spring-boot:run Application starts at localhost:8080. In database shemas would be deployed: How to check thay the application works? Use REST APi POST http://localhost:8080/process/start/Limit.  Rest returns process instance execution id. In log you will see: execution of limit delegate...</p>
<br>Links:</br>
https://github.com/camunda/camunda-bpm-examples/tree/master/multi-tenancy/tenant-identifier-shared
https://docs.camunda.org/manual/7.15/user-guide/process-engine/multi-tenancy/
https://assets.ctfassets.net/vpidbgnakfvf/6qPAgbht0kyc2mIe2mcosC/13d6594affb6241b2714edebc73b421f/Multi-tenancy.pdf

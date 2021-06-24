package example.service.impl;

import example.data.ProcessMap;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import example.service.CamundaService;
@Service
public class CamundaServiceImpl implements CamundaService {

    RuntimeService runtimeService;

    public CamundaServiceImpl(@Autowired ProcessEngine processEngine) {
        this.runtimeService = processEngine.getRuntimeService();
    }

    @Override
    public String start(String processKey) {
        String tenantId = new ProcessMap()
                .getProcessNameToTenant().get(processKey);
        ProcessInstance instance = runtimeService
                .createProcessInstanceByKey(processKey)
                .processDefinitionTenantId(tenantId)
                .caseInstanceId(tenantId)
                .execute();
        return instance.getProcessInstanceId();
    }
}

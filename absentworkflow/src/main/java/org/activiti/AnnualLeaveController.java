package org.activiti;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class AnnualLeaveController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    private NotificationService notificationService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/start-annual-leave", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void startHireProcess(@RequestBody Map<String, String> data) {
        Employee applicant = new Employee(data.get("name"), data.get("msg"));
        employeeRepository.save(applicant);
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employee", applicant);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("annualLeaveProcess", variables);

    }

}
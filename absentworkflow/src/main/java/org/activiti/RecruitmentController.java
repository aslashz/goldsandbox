package org.activiti;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecruitmentController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private CandidateEmployeeRepository candEmployeeRepository;

    private NotificationService notificationService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/start-recruitment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void startHireProcess(@RequestBody Map<String, String> data) {
        CandidateEmployee applicant = new CandidateEmployee(data.get("name"));
        candEmployeeRepository.save(applicant);
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("candEmployee", applicant);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("recruitmentProcess", variables);

    }
    
    @RequestMapping(value = "/show-candidate", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CandidateEmployee> showCandidate() {
        List<CandidateEmployee> candEmployee = candEmployeeRepository.findAll();
        return candEmployee;
    }

}
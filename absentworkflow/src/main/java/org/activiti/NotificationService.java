package org.activiti;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    @Autowired
    private RuntimeService runtimeService;
    
    public void rejectLeaveHRD(DelegateExecution execution) {
        System.out.println("Rejected by HRD\nEmp:"+execution.getVariable("employee"));
    }
    
    public void acceptLeaveHRD(DelegateExecution execution) {
        System.out.println("Accepted by HRD\nEmp:"+execution.getVariable("employee"));
    }

}

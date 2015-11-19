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
        System.out.println("Rejected by HRD\n    [+] Emp:"+execution.getVariable("employee"));
    }
    
    public void acceptLeaveHRD(DelegateExecution execution) {
        System.out.println("Accepted by HRD\n    [+] Emp:"+execution.getVariable("employee"));
    }
    
    public void rejectLeaveSUP(DelegateExecution execution) {
        System.out.println("Rejected by supervisor\n    [+] Emp:"+execution.getVariable("employee"));
    }
    
    public void acceptLeaveSUP(DelegateExecution execution) {
        System.out.println("Accepted by supervisor\n    [+] Emp:"+execution.getVariable("employee"));
    }
    
    public void acceptSelectionStage(DelegateExecution execution) {
        CandidateEmployee candEmployee = (CandidateEmployee) execution.getVariable("candEmployee");
        candEmployee.setStatus(CandidateEmployeeRepository.STATUS_ACC);
        System.out.println("Candidate employee "+execution.getVariable("candEmployee") + " inserted into database");
    }
    public void acceptQualificationStage(DelegateExecution execution) {
        CandidateEmployee candEmployee = (CandidateEmployee) execution.getVariable("candEmployee");
        candEmployee.setStatus(CandidateEmployeeRepository.STATUS_PEN);
        System.out.println("Candidate employee "+execution.getVariable("candEmployee") + " saved for reference");
    }
    public void rejectQualificationStage(DelegateExecution execution) {
        CandidateEmployee candEmployee = (CandidateEmployee) execution.getVariable("candEmployee");
        candEmployee.setStatus(CandidateEmployeeRepository.STATUS_REJ);
        System.out.println("Candidate employee "+execution.getVariable("candEmployee") + " has been rejected");
    }
}

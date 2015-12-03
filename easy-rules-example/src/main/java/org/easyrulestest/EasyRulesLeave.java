package org.easyrulestest;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.easyrules.core.BasicRule;


class EasyRulesAcceptLeave extends BasicRule {
    private LeaveStatus leaveStatus;

    public LeaveStatus getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(LeaveStatus leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public EasyRulesAcceptLeave(LeaveStatus leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    
    public boolean evaluate() {
        int counter = 0;
        counter += (leaveStatus.getEmployee().getStartContract().getDay() <= 15 ? 1 : 0);
        counter += (leaveStatus.getLeaveDate().getMonth() - leaveStatus.getEmployee().getStartContract().getMonth());
        return (counter - leaveStatus.getLeaveDuration() >= 0);
    }

    
    public void execute() {
        System.out.println(leaveStatus.getEmployee()+" ACCEPTED");
        leaveStatus.setStatus(LeaveStatus.ACCEPTED);
    }

}


class EasyRulesRejectLeave extends BasicRule{
    public LeaveStatus leaveStatus;

    public LeaveStatus getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(LeaveStatus leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public EasyRulesRejectLeave(LeaveStatus leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    
    public boolean evaluate() {
        int counter = 0;
        counter += (leaveStatus.getEmployee().getStartContract().getDay() <= 15 ? 1 : 0);
        counter += (leaveStatus.getLeaveDate().getMonth() - leaveStatus.getEmployee().getStartContract().getMonth());
        return (counter - leaveStatus.getLeaveDuration() < 0);
    }

    public void execute() {
        System.out.println(leaveStatus.getEmployee()+" REJECTED");
        leaveStatus.setStatus(LeaveStatus.REJECTED);
    }

}

package org.easyrulestest;

public class LeaveStatus {

    public static final int ACCEPTED = 1;
    public static final int REJECTED = 0;
    public static final int UNKNOWN = -1;
    private Employee employee;
    private Date leaveDate;
    private int leaveDuration;
    private int status;

    public LeaveStatus(Employee employee, Date leaveDate, int leaveDuration) {
        this.employee = employee;
        this.leaveDate = leaveDate;
        this.leaveDuration = leaveDuration;
        this.status = LeaveStatus.UNKNOWN;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public int getLeaveDuration() {
        return leaveDuration;
    }

    public void setLeaveDuration(int leaveDuration) {
        this.leaveDuration = leaveDuration;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

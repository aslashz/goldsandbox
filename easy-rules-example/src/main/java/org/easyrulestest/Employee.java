package org.easyrulestest;



public class Employee {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(String name, Date startContract) {
        this.name = name;
        this.setStartContract(startContract);
    }

    public Date getStartContract() {
        return startContract;
    }

    private String name;
    private Date startContract;

    public void setStartContract(Date startContract) {
        this.startContract = startContract;
    }

    public String toString() {
        return String.format("Employee [name='%s']", this.name);
    }
}

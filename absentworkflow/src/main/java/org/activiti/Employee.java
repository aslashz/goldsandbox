package org.activiti;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String msg;

    public Employee() {

    }

    public Employee(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("Employee[id=%d, name='%s', msg='%s']", this.id, this.name, this.msg);
    }
}
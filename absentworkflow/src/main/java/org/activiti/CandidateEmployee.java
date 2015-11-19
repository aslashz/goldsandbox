package org.activiti;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CandidateEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String name;

    private String status;

    public CandidateEmployee() {
        this("NULL");
    }

    public CandidateEmployee(String name) {
        this(name, CandidateEmployeeRepository.STATUS_UNK);
    }

    public CandidateEmployee(String name, String msg) {
        this.name = name;
        this.status = msg;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("Employee[id=%d, name='%s', status='%s']", this.id, this.name, this.status);
    }
}
package org.activiti;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateEmployeeRepository extends JpaRepository<CandidateEmployee, Long> {
    public static String STATUS_ACC = "STATUS ACCEPTED";
    public static String STATUS_REJ = "STATUS REJECTED";
    public static String STATUS_PEN = "STATUS PENDING";
    public static String STATUS_UNK = "STATUS UNKNOWN";
}
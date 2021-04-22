package com.honda.am.cqp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.honda.am.cqp.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

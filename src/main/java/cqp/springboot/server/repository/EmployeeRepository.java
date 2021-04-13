package cqp.springboot.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cqp.springboot.server.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

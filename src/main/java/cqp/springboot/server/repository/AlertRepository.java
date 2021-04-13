package cqp.springboot.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cqp.springboot.server.model.Alert;


@Repository
public interface AlertRepository extends JpaRepository<Alert, Long>{

}

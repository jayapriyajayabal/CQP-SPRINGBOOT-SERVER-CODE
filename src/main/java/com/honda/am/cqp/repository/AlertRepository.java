package com.honda.am.cqp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.honda.am.cqp.model.Alert;


@Repository
public interface AlertRepository extends JpaRepository<Alert, Long>{

}

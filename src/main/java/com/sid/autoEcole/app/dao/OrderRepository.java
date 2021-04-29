package com.sid.autoEcole.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sid.autoEcole.app.entities.Order;
import com.sid.autoEcole.app.entities.Student;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {

}

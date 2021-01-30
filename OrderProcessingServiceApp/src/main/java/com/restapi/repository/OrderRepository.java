package com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.model.*;

@Repository
public interface OrderRepository extends JpaRepository<Order1, Integer> {

}

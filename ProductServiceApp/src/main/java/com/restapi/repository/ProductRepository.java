package com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.model.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}

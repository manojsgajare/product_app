package com.program.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.program.entity.Product;

@Repository
public interface productDao extends  JpaRepository<Product, Integer> {

	Product save(Integer id);


}

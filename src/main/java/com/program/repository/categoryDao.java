package com.program.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.program.entity.Category;

@Repository
public interface categoryDao extends JpaRepository<Category,Integer> {

}

package com.ravi.fintrack.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ravi.fintrack.model.Category;

@Repository
public interface ICategoryDao extends JpaRepository<Category, Integer> {

}

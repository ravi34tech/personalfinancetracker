package com.ravi.fintrack.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ravi.fintrack.model.Category;

@Repository
public interface ICategoryDao extends JpaRepository<Category, Integer> {

	List<Category> findByName(String name);
	
	List<Category> findByColorCode(String colorCode);
	
	@Query("select c from category c where c.name like :name and c.colorCode like :colorCode")
	List<Category> findByNameAndCode(@Param("name") String name, @Param("colorCode") String colorCode);

}

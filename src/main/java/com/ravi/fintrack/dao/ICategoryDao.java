package com.ravi.fintrack.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ravi.fintrack.model.Category;

@Repository
public interface ICategoryDao extends JpaRepository<Category, Integer> {

	List<Category> findByNameAndDeleted(String name, boolean deleted);
	
	List<Category> findByColorCode(String colorCode);
	
	@Query("select c from Category c where c.name like :name and c.colorCode like :colorCode and c.deleted = false")
	List<Category> findByCriteria(@Param("name") String name, @Param("colorCode") String colorCode);
	
	@Query("select c from Category c where c.deleted = false")
	List<Category> getActiveCategories();	

}

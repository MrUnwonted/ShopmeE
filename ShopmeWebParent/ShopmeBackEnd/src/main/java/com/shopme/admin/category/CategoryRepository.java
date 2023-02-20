package com.shopme.admin.category;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.shopme.common.entity.Category;


public interface CategoryRepository extends CrudRepository<Category, Integer> {
	  
	@Query("SELECT u FROM Category u WHERE u.alias = :alias")
	    public Category getCatByAlias(@Param("alias") String alias);

		public Long countById(Integer Id);
    
	    @Query("UPDATE Category u SET u.enabled = ?2 WHERE u.id = ?1")
	    @Modifying		
	    public void updateEnabledStatus(Integer id, boolean enabled);

}

package com.shopme.admin.category;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.shopme.common.entity.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {

	Category save(Category category);

	Object findById(int i);



}

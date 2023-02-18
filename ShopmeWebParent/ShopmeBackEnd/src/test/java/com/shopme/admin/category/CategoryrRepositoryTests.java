package com.shopme.admin.category;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Category;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoryrRepositoryTests {

	@Autowired
	private CategoryRepository repo;
	
	@Test
	public void testCreateRootCategory() {
		Category category = new Category("Computers");
		Category savedCategory = repo.save(category);
		
		assertThat(savedCategory.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateSubCategory() {
		Category parent = new Category(1);
		Category subCategory = new Category("Desktops", parent);
		Category savedCategory = repo.save(subCategory);
		
		assertThat(savedCategory.getId()).isGreaterThan(0);
	}
	
//	@Test
//	public void testGetCategory() {
//		Category category = repo.findById(1).get();
//		System.out.println(category.getName());
//		
//		Set<Category> children  = category.getChildren();
//		for (Category subCategory : children) {
//			System.out.println(subCategory.getName());
//		}
//		assertThat(children.size()).isGreaterThan(0);
//	}
}

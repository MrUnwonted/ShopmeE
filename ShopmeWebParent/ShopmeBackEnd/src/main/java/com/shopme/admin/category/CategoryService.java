package com.shopme.admin.category;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.admin.user.UserNotFoundException;
import com.shopme.common.entity.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	
	public List<Category> listAll(){
		return (List<Category>) repo.findAll();
	}
	
	
	
	public List<Category> listCategoriesUsedInForm() {
		List<Category> categoriesUsedInForm = new ArrayList<>();
		
		Iterable<Category> categoriesInDB = repo.findAll();
		
//		for (Category category : categoriesInDB) {
//			if (category.getParent() == null) {
//				categoriesUsedInForm.add(new Category(category.getName()));
//				
//				Set<Category> children = category.getChildren();
//				
//				for (Category subCategory : children) {
//					String name = "--" + subCategory.getName();
//					categoriesUsedInForm.add(new Category(name));
//					
//					listChildren(categoriesUsedInForm, subCategory, 1);
//				}
//			}
//		}		
		
		return categoriesUsedInForm;
	}
	
	
	
	
	
	
	
//	public Category save(Category cat) {
//		boolean isUpdatingCategory = (cat.getId() != null) ; 
//		
//		if(isUpdatingCategory) {
//			Category existingCategory= catRepo.findById(cat.getId()).get(); 
//		}	
//		
//		return catRepo.save(cat);
//	}
//	
//	public boolean isCategoryUnique(Integer id, String name){
//		Category catByAlias =catRepo.getCatByName(name);
//		
//		if(catByAlias == null) return true;
//		boolean isCreatingNew = (id == null);
//		
//		if(isCreatingNew) {
//				if(catByAlias != null ) return false;
//		} else {
//			if (catByAlias .getId() != id) {
//				return false;
//			}
//		}
//		
//		return true;
//	}
//	
//	public Category get(Integer id) throws UserNotFoundException {
//		
//		try {
//		return catRepo.findById(id).get();
//		} catch (NoSuchElementException ex) {
//			throw new UserNotFoundException("Could not find any Category with ID" + id);
//		}
//	}
//	
//	public void delete(Integer id) throws UserNotFoundException {
//		Long countById = catRepo.countById(id);
//		if (countById == null || countById == 0) {
//			throw new UserNotFoundException("Could not find any Category with ID" + id);
//		}
//		catRepo.deleteById(id);
//	}
//	
//	public void updateCategoryEnabledStatus(Integer id, boolean enabled) {
//		catRepo.updateEnabledStatus(id, enabled);
//	}

	
}

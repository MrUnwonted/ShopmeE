package com.shopme.admin.category;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.admin.user.UserNotFoundException;
import com.shopme.common.entity.Category;
import com.shopme.common.entity.User;
@Service
public class CategoryService {

	@Autowired
	private CategoryRepository catRepo;
	
	
	public List<Category> listAll(){
		return (List<Category>) catRepo.findAll();
	}
	
	public Category save(Category cat) {
		boolean isUpdatingCategory = (cat.getId() != null) ; 
		
		if(isUpdatingCategory) {
			Category existingCategory= catRepo.findById(cat.getId()).get(); 
		}	
		
		return catRepo.save(cat);
	}
	
	public boolean isCategoryUnique(Integer id, String alias){
		Category catByAlias =catRepo.getCatByAlias(alias);
		
		if(catByAlias == null) return true;
		boolean isCreatingNew = (id == null);
		
		if(isCreatingNew) {
				if(catByAlias != null ) return false;
		} else {
			if (catByAlias .getId() != id) {
				return false;
			}
		}
		
		return true;
	}
	
	public Category get(Integer id) throws UserNotFoundException {
		
		try {
		return catRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			throw new UserNotFoundException("Could not find any Category with ID" + id);
		}
	}
	
	public void delete(Integer id) throws UserNotFoundException {
		Long countById = catRepo.countById(id);
		if (countById == null || countById == 0) {
			throw new UserNotFoundException("Could not find any Category with ID" + id);
		}
		catRepo.deleteById(id);
	}
	
	public void updateCategoryEnabledStatus(Integer id, boolean enabled) {
		catRepo.updateEnabledStatus(id, enabled);
	}

	
}

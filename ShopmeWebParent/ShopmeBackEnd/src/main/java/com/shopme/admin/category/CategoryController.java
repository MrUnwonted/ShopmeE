package com.shopme.admin.category;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopme.common.entity.Category;


@Controller
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	
	@GetMapping("/categories")
	public String listCategories(Model model) {
		List<Category> listCategories= service.listAll();
		model.addAttribute("listCategories", listCategories);
		return  "categories/categories";
	}
	
	
	@GetMapping("/categories/new")
	public String newCategory(Model model) {
//		Category category = new Category();
		List<Category> listCategories = service.listCategoriesUsedInForm();
//		category.setEnabled(true);
		model.addAttribute("category", new Category());
		model.addAttribute("listCategories", listCategories);
		model.addAttribute("pageTitle", "Create New Category");
		
		return "categories/categoryform";
	}
	
//	@PostMapping("/categories/save")
//	public String saveCategory(Category category, RedirectAttributes redirectAttributes)  {
//		
////		if (!multipartFile.isEmpty()) {
////			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//////			category.setPhotos(fileName);
////			Category savedcategory = service.save(category);
////			
////			String uploadDir = "category-photos/" + savedcategory.getId();
////			
////			FileUploadUtil.cleanDir(uploadDir);
////			FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
////			
////		} else {
//////			if (category.getPhotos().isEmpty()) category.setPhotos(null);
////			
////		}
//		service.save(category);
//		
//		redirectAttributes.addFlashAttribute("message", "The category has been saved successfully.");
//		
//		return "redirect:/categories";
//	}
//	
//	@GetMapping("/categories/edit/{id}")
//	public String editcategory(@PathVariable(name = "id") Integer id,
//			Model model,
//			RedirectAttributes redirectAttributes) {
//		try {
//			Category category = service.get(id);
//			model.addAttribute("category", category);
//			model.addAttribute("pageTitle", "Edit category (ID: " +id+ " )");
//			return "categoryform";
//		}catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", e.getMessage());	
//			return "redirect:/categories";
//		}
//		
//		
//	}
//	
//	
//	@GetMapping("/categories/delete/{id}")
//	public String deletecategory(@PathVariable(name = "id") Integer id, 
//			Model model,
//			RedirectAttributes redirectAttributes) {
//		try {
//			service.delete(id);
////			String categoryPhotosDir = "category-photos/" + id;
//			
//			redirectAttributes.addFlashAttribute("message", 
//					"The category ID " + id + " has been deleted successfully");
//		} catch (Exception ex) {
//			redirectAttributes.addFlashAttribute("message", ex.getMessage());
//		}
//		
//		return "redirect:/categories";
//	}
//	
//	
//	@GetMapping("/categories/{id}/enabled/{status}")
//	public String updatecategoryEnabledStatus(@PathVariable("id") Integer id,
//			@PathVariable("status") boolean enabled, RedirectAttributes redirectAttributes) {
//				service.updateCategoryEnabledStatus(id, enabled);
//				String status = enabled ? "enabled" : "disabled";
//				String message =  "The category ID" + id + " has been " + status;
//				redirectAttributes.addFlashAttribute("message", message);
//						
//		return "redirect:/categories";
//	}
	
}

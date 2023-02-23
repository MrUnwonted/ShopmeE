package com.shopme;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shopme.category.CategoryService;
import com.shopme.common.entity.Category;

@Controller
public class UserController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/shop")
	public String viewHomePage() {
		return "shop";
	}
	
	@GetMapping("/cart")
	public String viewCartPage() {
		return "cart";
	}
	
	@GetMapping("/about")
	public String viewAboutPage() {
		return "about";
	}
	
	@GetMapping("/contact")
	public String viewContactPage() {
		return "contact";
	}
	
	@GetMapping("/checkout")
	public String viewcheckoutPage() {
		return "checkout";
	}
	
	@GetMapping("/thankyou")
	public String viewthankyouPage() {
		return "thankyou";
	}
	
	@GetMapping("/categories")
	public String viewHomePage(Model model) {
		List<Category> listCategories = categoryService.listNoChildrenCategories();
		model.addAttribute("listCategories", listCategories);
		
		return "categories";
	}
	
	@GetMapping("/shop-single")
	public String viewcataloguePage() {
		return "shop-single";
	}
	
	
	
}

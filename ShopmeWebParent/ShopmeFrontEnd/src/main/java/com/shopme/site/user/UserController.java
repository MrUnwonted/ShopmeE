package com.shopme.site.user;

import com.shopme.common.entity.Category;
import com.shopme.site.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/shop")
	public String viewHomePage(Model m) {
		List<Category> listCategories = categoryService.listNoChildrenCategories();
		m.addAttribute("listCategories",listCategories);
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
	
	
	@GetMapping("/shop-single")
	public String viewcataloguePage() {
		return "shop-single";
	}

	@GetMapping("/categories")
	public String viewCategoryPage(Model model) {
		List<Category> listCategories = categoryService.listNoChildrenCategories();
		model.addAttribute("listCategories",listCategories);
		return "categories";
	}
	
	
}

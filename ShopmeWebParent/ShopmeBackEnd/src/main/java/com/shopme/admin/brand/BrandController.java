package com.shopme.admin.brand;

import java.util.List;

import com.shopme.admin.category.CategoryService;
import com.shopme.common.entity.Category;
import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shopme.common.entity.Brand;

@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/brands")
    public String listAll(Model model) {
        List<Brand> listBrands = brandService.listAll();
        model.addAttribute("listBrands", listBrands);

        return "brands/brands";
    }

   @GetMapping("/brands/new")
    public String newBrand(Model model) {
      List<Category> listCategories = categoryService.listCategoriesUsedInForm();
       model.addAttribute("listCategories", listCategories);
       model.addAttribute("brand", new Brand());
       model.addAttribute("pageTitle", "Create New Brand");

        return "brands/brandform";
    }


}

package com.shopme.admin.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CategoryRestController {

    @Autowired
    private CategoryService service;

//    @PostMapping("/categories/check_name")
//    public String checkDuplicateEmail(@Param("id") Integer id,@Param("name") String name){
//        return service.isCategoryUnique(id,name) ? "OK" : "Duplicated";
//    }

}

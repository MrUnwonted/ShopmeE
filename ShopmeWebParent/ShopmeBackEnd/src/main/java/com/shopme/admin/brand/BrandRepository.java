package com.shopme.admin.brand;

import com.shopme.common.entity.Brand;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BrandRepository extends PagingAndSortingRepository<Brand, Integer> {

    public Long countById(Integer id);

    public Brand findByName(String name);

}

package com.shopme.admin.product;

import com.shopme.common.entity.Brand;
import com.shopme.common.entity.Category;
import com.shopme.common.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ProductRepositoryTests {

    @Autowired
    ProductRepository repo;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public  void testCreateProduct1(){
        Brand brand = entityManager.find(Brand.class,10);
        Category category = entityManager.find(Category.class,15);

        Product product = new Product();
        product.setName("Samsung Galaxy A31");
        product.setAlias("samsung_galaxy_a31");
        product.setShortDescription("A good SmartPhone from Samsung");
        product.setFullDescription("This is a full descrption");

        product.setBrand(brand);
        product.setCategory(category);

        product.setPrice(456);
        product.setCreatedTime(new Date());
        product.setUpdatedTime(new Date());

        Product saveProduct = repo.save(product);

        assertThat(saveProduct).isNotNull();
        assertThat(saveProduct.getId()).isGreaterThan(0);
    }

    @Test
    public  void testCreateProduct2(){
        Brand brand = entityManager.find(Brand.class,4);
        Category category = entityManager.find(Category.class,6);

        Product product = new Product();
        product.setName("HP_Pavilion_15");
        product.setAlias("hp_pavilion_15");
        product.setShortDescription("One of the best laptop");
        product.setFullDescription("This is a full descrption");

        product.setBrand(brand);
        product.setCategory(category);

        product.setPrice(456);
        product.setCreatedTime(new Date());
        product.setUpdatedTime(new Date());

        Product saveProduct = repo.save(product);

        assertThat(saveProduct).isNotNull();
        assertThat(saveProduct.getId()).isGreaterThan(0);
    }

    @Test
    public  void testAllProducts(){
        Iterable<Product> iterableProducts = repo.findAll();

        iterableProducts.forEach(System.out::println);
    }

    @Test
    public void testGetProduct(){
        Integer id = 2;
        Product product = repo.findById(id).get();
        System.out.println(product);

        assertThat(product).isNotNull();
    }

    @Test
    public void testUpdateProduct(){
        Integer id = 1;
        Product product = repo.findById(id).get();
        product.setEnabled(true);

        repo.save(product);

        Product updatedProduct = entityManager.find(Product.class,id);

        System.out.println(product);
        assertThat(updatedProduct.getPrice()).isEqualTo(499);
    }

}

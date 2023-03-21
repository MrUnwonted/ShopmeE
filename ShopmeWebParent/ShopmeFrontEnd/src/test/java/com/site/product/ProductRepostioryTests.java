package com.shopme.product;

import com.shopme.common.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductRepostioryTests {

    @Autowired
    ProductRepository repo;

    @Test
    public void testFindByAlias(){
        String alias = "LG-G-Flex,-Titan-Silver-32GB";
        Product product = repo.findByAlias(alias);

        assertThat(product).isNotNull();

    }

}

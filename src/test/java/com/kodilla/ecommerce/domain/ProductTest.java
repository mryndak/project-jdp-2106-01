package com.kodilla.ecommerce.domain;

import com.kodilla.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testGetAll() {
        //Given
        Product product1 = Product.builder().build();
        Product product2 = Product.builder().build();
        productRepository.save(product1);
        productRepository.save(product2);
        //When
        List<Product> products = productRepository.findAll();
        //Then
        assertEquals(2, products.size());
        //CleanUp
        productRepository.delete(product1);
        productRepository.delete(product2);
    }

    @Test
    void testCreate() {
        //Given
        Product product = Product.builder().build();
        productRepository.save(product);
        //When
        Long id = product.getId();
        //Then
        assertNotEquals(0, id);
        //CleanUp
        productRepository.deleteById(id);
    }

    @Test
    void testUpdate() {
        //Given & When
        Product product1 = Product.builder()
                .name("kurtka")
                .build();
        productRepository.save(product1);
        Long id = product1.getId();
        Optional<Product> product1FromEntity = productRepository.findById(id);
        Product product2 = Product.builder()
                .id(id)
                .name("spodnie")
                .build();
        productRepository.save(product2);
        Optional<Product> product2FromEntity = productRepository.findById(id);
        //Then
        assertNotEquals(product1FromEntity.get().getName(), product2FromEntity.get().getName());
        //CleanUp
        productRepository.deleteById(id);
    }

    @Test
    void testDelete() {
        //Given
        Product product = Product.builder()
                .name("kurtka")
                .build();
        productRepository.save(product);
        Long id = product.getId();
        assertTrue(productRepository.existsById(id));
        //When
        productRepository.deleteById(id);
        //Then
        assertFalse(productRepository.existsById(id));
    }
}

package com.kodilla.ecommerce.group;

import com.kodilla.ecommerce.domain.Group;
import com.kodilla.ecommerce.domain.Product;
import com.kodilla.ecommerce.repository.GroupRepository;
import com.kodilla.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;


@SpringBootTest
public class GroupEntityTestSuite {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    @Test
    void shouldSave() {
        //GIVEN
        Group testGroup1 = new Group();
        Group testGroup2 = new Group();

        //WHEN

        long currentDbId = groupRepository.count();
        groupRepository.save(testGroup1);
        groupRepository.save(testGroup2);

        //THEN

        Assertions.assertEquals(currentDbId + 2L, groupRepository.count());
        Assertions.assertTrue(groupRepository.findAll().contains(testGroup1));
        Assertions.assertTrue(groupRepository.findAll().contains(testGroup2));

        // CLEANUP
        groupRepository.deleteAll();

    }

    @Transactional
    @Test
    void shouldFindById() {

        //GIVEN
        Group testGroup1 = new Group();
        Group testGroup2 = new Group();
        Group testGroup3 = new Group();
        Group testGroup4 = new Group();

        long currentDbId = groupRepository.count();

        //WHEN
        groupRepository.save(testGroup1);
        groupRepository.save(testGroup2);
        groupRepository.save(testGroup3);
        groupRepository.save(testGroup4);


        long testGroup1Id = testGroup1.getId();
        long testGroup2Id = testGroup2.getId();
        long testGroup3Id = testGroup3.getId();
        long testGroup4Id = testGroup4.getId();

        //THEN

        Assertions.assertEquals(currentDbId + 4L, groupRepository.count());
        Assertions.assertEquals(currentDbId + 2L, testGroup1Id);
        Assertions.assertEquals(currentDbId + 3L, testGroup2Id);
        Assertions.assertEquals(currentDbId + 4L, testGroup3Id);
        Assertions.assertEquals(currentDbId + 5L, testGroup4Id);

        //CLEANUP
        groupRepository.deleteAll();

    }

    @Transactional
    @Test
    void shouldFindAll() {

        //GIVEN
        Group testGroup1 = new Group();
        Group testGroup2 = new Group();
        Group testGroup3 = new Group();
        Group testGroup4 = new Group();
        Group testGroup5 = new Group();

        //WHEN
        groupRepository.save(testGroup1);
        groupRepository.save(testGroup2);
        groupRepository.save(testGroup3);
        groupRepository.save(testGroup4);

        //THEN
        Assertions.assertTrue(groupRepository.findAll().contains(testGroup1));
        Assertions.assertTrue(groupRepository.findAll().contains(testGroup2));
        Assertions.assertTrue(groupRepository.findAll().contains(testGroup3));
        Assertions.assertTrue(groupRepository.findAll().contains(testGroup4));
        Assertions.assertFalse(groupRepository.findAll().contains(testGroup5));

        //CLEANUP
        groupRepository.deleteAll();

    }

    @Transactional
    @Test
    void shouldDeleteGroup() {
        //GIVEN
        long currentDbSize = groupRepository.count();
        Group testGroup1 = new Group();
        Group testGroup2 = new Group();
        Group testGroup3 = new Group();
        Group testGroup4 = new Group();

        groupRepository.save(testGroup1);
        groupRepository.save(testGroup2);
        groupRepository.save(testGroup3);
        groupRepository.save(testGroup4);

        //WHEN

        groupRepository.delete(testGroup2);
        groupRepository.delete(testGroup3);
        long sizeAfterDelete = groupRepository.count();

        //THEN
        Assertions.assertEquals(currentDbSize + 2L, sizeAfterDelete);
    }

    @Transactional
    @Test
    void ShouldTestRelationBetweenGroupAndProduct() {
        groupRepository.deleteAll();
        Group testGroup1 = new Group();
        Group testGroup2 = new Group();
        Group testGroup3 = new Group();
        Group testGroup4 = new Group();
        groupRepository.save(testGroup1);
        groupRepository.save(testGroup2);
        groupRepository.save(testGroup3);
        groupRepository.save(testGroup4);

        testGroup1.setName("Test Group 1");
        testGroup2.setName("Test Group 2");
        testGroup3.setName("Test Group 3");
        testGroup4.setName("Test Group 4");
        testGroup1.setId(1L);
        testGroup2.setId(2L);
        testGroup3.setId(3L);
        testGroup4.setId(4L);
        Product product1 = new Product(1L, "test1", "test1", "test descrition",
                new BigDecimal("100.0"), testGroup1);

        Product product2 = new Product(2L, "test2", "test2", "test descrition",
                new BigDecimal("100.0"), testGroup1);
        Product product3 = new Product(3L, "test3", "test3", "test descrition",
                new BigDecimal("100.0"), testGroup2);
        Product product4 = new Product(4L, "test4", "test4", "test descrition",
                new BigDecimal("100.0"), testGroup2);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);

        //WHEN
        testGroup1.getProductList().add(product1);
        testGroup1.getProductList().add(product2);
        testGroup2.getProductList().add(product3);
        testGroup2.getProductList().add(product4);
        List<Product> productArrayListGroup1 = testGroup1.getProductList();
        List<Product> productArrayListGroup2 = testGroup2.getProductList();
        List<Product> productArrayListGroup3 = testGroup3.getProductList();
        List<Product> productArrayListGroup4 = testGroup4.getProductList();

        //THEN
        Assertions.assertTrue(productArrayListGroup1.contains(product1));
        Assertions.assertTrue(productArrayListGroup1.contains(product2));
        Assertions.assertTrue(productArrayListGroup2.contains(product3));
        Assertions.assertTrue(productArrayListGroup2.contains(product4));
        Assertions.assertFalse(productArrayListGroup1.contains(product4));
        Assertions.assertFalse(productArrayListGroup1.contains(product3));
        Assertions.assertTrue(productArrayListGroup3.isEmpty());
        Assertions.assertTrue(productArrayListGroup4.isEmpty());
    }

}

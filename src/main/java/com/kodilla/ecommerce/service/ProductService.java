package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.dto.ProductDto;
import com.kodilla.ecommerce.mapper.ProductMapper;
import com.kodilla.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    private final ProductMapper mapper;

    public List<ProductDto> getAllProducts() {
        return mapper.mapToProductDtoList(repository.findAll());
    }

    public ProductDto getProductById(long id) {
        if (isIdNotExists(id)) return ProductDto.builder().build();
        return mapper.mapToProductDto(repository.findById(id));
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
    private boolean isIdNotExists(long id) {
        if (!repository.existsById(id)) {
            log.error("PRODUCT NOT FOUND");
            return true;
        }
        return false;
    }

>>>>>>> f4102c8 (JDP210601-21_rev.1: comments improvements on real ProductController methods, added relations in Cart and Group entities)
    public ProductDto createProduct(ProductDto productDto) {
        return mapper.mapToProductDto(repository.save(mapper.mapToProduct(productDto)));
    }

    public ProductDto updateProduct(ProductDto productDto) {
        if (isProductDtoNotExists(productDto)) return ProductDto.builder().build();
        return mapper.mapToProductDto(repository.save(mapper.mapToProduct(productDto)));
=======
    public ProductDto createProduct(ProductDto product) {
        return mapper.mapToProductDto(repository.save(mapper.mapToProduct(product)));
    }

    public ProductDto updateProduct(ProductDto product) {
        return mapper.mapToProductDto(repository.save(mapper.mapToProduct(product)));
>>>>>>> b1c4854 (JDP210601-21: real implementation of ProductController, added ProductMapper, ProductRepository, ProductService, added @Builder annotation in Product)
=======
    public ProductDto createProduct(ProductDto productDto) {
        return mapper.mapToProductDto(repository.save(mapper.mapToProduct(productDto)));
    }

    public ProductDto updateProduct(ProductDto productDto) {
        return mapper.mapToProductDto(repository.save(mapper.mapToProduct(productDto)));
>>>>>>> 422548b (JDP210601-21_rev.1: some changes in arguments names)
    }

    private boolean isProductDtoNotExists(ProductDto productDto) {
        if (!repository.existsById(productDto.getId()) || productDto.getId() == null) {
            log.error("PRODUCT CANNOT BE UPDATED");
            return true;
        }
        return false;
    }

    public void deleteProduct(long id) {
        repository.deleteById(id);
    }
}

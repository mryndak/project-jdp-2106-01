package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.dto.ProductDto;
import com.kodilla.ecommerce.mapper.ProductMapper;
import com.kodilla.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public List<ProductDto> getAllProducts() {
        return mapper.mapToProductDtoList(repository.findAll());
    }

    public ProductDto getProductById(long id) {
        return mapper.mapToProductDto(repository.findById(id));
    }

<<<<<<< HEAD
    public ProductDto createProduct(ProductDto productDto) {
        return mapper.mapToProductDto(repository.save(mapper.mapToProduct(productDto)));
    }

    public ProductDto updateProduct(ProductDto productDto) {
        return mapper.mapToProductDto(repository.save(mapper.mapToProduct(productDto)));
=======
    public ProductDto createProduct(ProductDto product) {
        return mapper.mapToProductDto(repository.save(mapper.mapToProduct(product)));
    }

    public ProductDto updateProduct(ProductDto product) {
        return mapper.mapToProductDto(repository.save(mapper.mapToProduct(product)));
>>>>>>> b1c4854 (JDP210601-21: real implementation of ProductController, added ProductMapper, ProductRepository, ProductService, added @Builder annotation in Product)
    }

    @Transactional
    public void deleteProduct(long id) {
        repository.deleteById(id);
    }
}

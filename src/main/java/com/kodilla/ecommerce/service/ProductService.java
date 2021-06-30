package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.dto.ProductDto;
import com.kodilla.ecommerce.mapper.ProductMapper;
import com.kodilla.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
=======
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

>>>>>>> b1c4854 (JDP210601-21: real implementation of ProductController, added ProductMapper, ProductRepository, ProductService, added @Builder annotation in Product)
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
<<<<<<< HEAD

=======
>>>>>>> b1c4854 (JDP210601-21: real implementation of ProductController, added ProductMapper, ProductRepository, ProductService, added @Builder annotation in Product)
    private final ProductMapper mapper;

    public List<ProductDto> getAllProducts() {
        return mapper.mapToProductDtoList(repository.findAll());
    }

    public ProductDto getProductById(long id) {
<<<<<<< HEAD
        if (isIdNotExists(id)) return ProductDto.builder().build();
        return mapper.mapToProductDto(repository.findById(id));
    }

    private boolean isIdNotExists(long id) {
        if (!repository.existsById(id)) {
            log.error("PRODUCT NOT FOUND");
            return true;
        }
        return false;
    }

    public ProductDto createProduct(ProductDto productDto) {
        return mapper.mapToProductDto(repository.save(mapper.mapToProduct(productDto)));
    }

    public ProductDto updateProduct(ProductDto productDto) {
        if (isProductDtoNotExists(productDto)) return ProductDto.builder().build();
        return mapper.mapToProductDto(repository.save(mapper.mapToProduct(productDto)));
    }

    private boolean isProductDtoNotExists(ProductDto productDto) {
        if (!repository.existsById(productDto.getId()) || productDto.getId() == null) {
            log.error("PRODUCT CANNOT BE UPDATED");
            return true;
        }
        return false;
    }

=======
        return mapper.mapToProductDto(repository.findById(id));
    }

    public ProductDto createProduct(ProductDto product) {
        return mapper.mapToProductDto(repository.save(mapper.mapToProduct(product)));
    }

    public ProductDto updateProduct(ProductDto product) {
        return mapper.mapToProductDto(repository.save(mapper.mapToProduct(product)));
    }

    @Transactional
>>>>>>> b1c4854 (JDP210601-21: real implementation of ProductController, added ProductMapper, ProductRepository, ProductService, added @Builder annotation in Product)
    public void deleteProduct(long id) {
        repository.deleteById(id);
    }
}

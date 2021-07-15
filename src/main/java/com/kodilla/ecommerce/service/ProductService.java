package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.domain.Group;
import com.kodilla.ecommerce.domain.Product;
import com.kodilla.ecommerce.dto.ProductDto;
import com.kodilla.ecommerce.mapper.ProductMapper;
import com.kodilla.ecommerce.repository.GroupRepository;
import com.kodilla.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final GroupRepository groupRepository;

    public List<ProductDto> getAllProducts() {
        return productMapper.mapToProductDtoList((List<Product>) productRepository.findAll());
    }

    public ProductDto getProductById(long id) {
        if (isIdNotExists(id)) return null;
        return productMapper.mapToProductDto(productRepository.findById(id));
    }

    private boolean isIdNotExists(long id) {
        if (!productRepository.existsById(id)) {
            log.error("PRODUCT NOT FOUND");
            return true;
        }
        return false;
    }

    public ProductDto createProduct(long groupId, ProductDto productDto) {
        if (isProductSignatureExists(productDto)) return null;
        Product product = productMapper.mapToProduct(productDto);
        Group group = groupRepository.findById(groupId);
        group.getProductList().add(product);
        product.setGroup(group);
        return productMapper.mapToProductDto(productRepository.save(product));
    }

    private boolean isProductSignatureExists(ProductDto productDto) {
        if (productRepository.existsBySignature(productDto.getSignature()) || productDto.getSignature().isEmpty()) {
            log.error("PRODUCT ALREADY EXISTS");
            return true;
        }
        return false;
    }

    public ProductDto updateProduct(ProductDto productDto) {
        if (isProductNotExists(productMapper.mapToProduct(productDto))) return null;
        return productMapper.mapToProductDto(productRepository.save(productMapper.mapToProduct(productDto)));
    }

    private boolean isProductNotExists(Product product) {
        if (!productRepository.existsById(product.getId()) || product.getId() == null) {
            log.error("PRODUCT CANNOT BE UPDATED");
            return true;
        }
        return false;
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}

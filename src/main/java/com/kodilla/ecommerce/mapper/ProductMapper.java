package com.kodilla.ecommerce.mapper;

import com.kodilla.ecommerce.domain.Product;
import com.kodilla.ecommerce.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapper {

    public Product mapToProduct(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
<<<<<<< HEAD
=======
                .groupId(productDto.getGroupId())
>>>>>>> b1c4854 (JDP210601-21: real implementation of ProductController, added ProductMapper, ProductRepository, ProductService, added @Builder annotation in Product)
                .build();
    }

    public ProductDto mapToProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
<<<<<<< HEAD
=======
                .groupId(product.getGroupId())
>>>>>>> b1c4854 (JDP210601-21: real implementation of ProductController, added ProductMapper, ProductRepository, ProductService, added @Builder annotation in Product)
                .build();
    }

    public List<ProductDto> mapToProductDtoList(List<Product> products) {
        return products.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }
}

package com.kodilla.ecommerce.mapper;

import com.kodilla.ecommerce.domain.Product;
import com.kodilla.ecommerce.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductMapper {

    public Product mapToProduct(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .signature(productDto.getSignature())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .build();
    }

    public ProductDto mapToProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .signature(product.getSignature())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public List<ProductDto> mapToProductDtoList(List<Product> products) {
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product : products) {
            productDtos.add(mapToProductDto(product));
        }
        return productDtos;
    }
}

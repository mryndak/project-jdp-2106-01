package com.kodilla.ecommerce.mapper;

import com.kodilla.ecommerce.domain.Product;
import com.kodilla.ecommerce.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProductMapperMapStruct {

    @Mapping(target = "group", ignore = true)
    @Mapping(target = "orderItems", ignore = true)
    @Mapping(target = "cartItems", ignore = true)
//    @Mapping(target = "price", source = "cost")
    public abstract Product mapToProduct(ProductDto productDto);

    @Mapping(source = "price", target = "cost")
    public abstract ProductDto mapToProductDto(Product product);

    public abstract List<ProductDto> mapToProductDtoList(List<Product> products);

}

package com.kodilla.ecommerce.mapper;

import com.kodilla.ecommerce.domain.Product;
import com.kodilla.ecommerce.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    public abstract Product mapToProduct(ProductDto productDto);

    @Mapping(source = "group.id", target = "groupId")
    @Mapping(target = "signature", ignore = true)
    public abstract ProductDto mapToProductDto(Product product);

    public abstract List<ProductDto> mapToProductDtoList(List<Product> products);
}

package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/v1/products", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class ProductsController {

    @GetMapping
    public List<ProductDto> getProducts() {
        /**
         * Dane pochodzą z pliku: specs/product.spec.json
         */
        return Arrays.asList(
                ProductDto.builder()
                        .id(1L)
                        .name("kurtka zimowa")
                        .description("")
                        .price(new BigDecimal(100))
                        .groupId(1L)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id ) {
        return ProductDto.builder()
                .id(1L)
                .name("kurtka zimowa")
                .build();
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody final ProductDto productDto) {
        return ProductDto.builder()
                .id(1L)
                .name("kurtka zimowa - created")
                .build();
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody final ProductDto productDto) {
        return ProductDto.builder()
                .id(1L)
                .name("kurtka zimowa - updated")
                .build();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable final Long id) {
    }
}

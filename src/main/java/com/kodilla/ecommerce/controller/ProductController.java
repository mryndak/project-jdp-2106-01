package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.dto.ProductDto;
import com.kodilla.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    public List<ProductDto> getProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable long id) {
        return service.getProductById(id);
    }

    @PostMapping(value = "/{groupId}", consumes = APPLICATION_JSON_VALUE)
    public ProductDto create(@PathVariable long groupId, @RequestBody ProductDto product) {
        return service.createProduct(groupId, product);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public ProductDto update(@RequestBody ProductDto product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.deleteProduct(id);
    }
}

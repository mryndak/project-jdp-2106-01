package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.domain.Product;
import com.kodilla.ecommerce.dto.ProductDto;
import com.kodilla.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping(value = "v1/product")
@RequiredArgsConstructor
public class ProductController {

//    private final ProductService service;

    //typ zwracany List<String> potrzebny do pierwszych testow, docelowo będzie List<ProductDto>
    @GetMapping
    public List<String> getProducts() throws IOException {
        return Files.readAllLines(Paths.get("specs/products.spec.json"));
    }

    //typ zwracany String potrzebny do pierwszych testów, docelowo będzie ProductDto
    @GetMapping("{id}")
    public String getById(@PathVariable long id) throws IOException {
        return Files.readString(Paths.get("specs/product.spec.json"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto create(@RequestBody Product product) {
        System.out.println(product.getName() + " created");
        return null;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto update(@RequestBody Product product) {
        System.out.println(product.getName() + " updated");
        return null;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        System.out.println("Product with id: " + id + " has been deleted");
    }
}

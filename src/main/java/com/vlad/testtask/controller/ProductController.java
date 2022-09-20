package com.vlad.testtask.controller;

import com.vlad.testtask.model.Product;
import com.vlad.testtask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public Optional<? extends Product> getById(@PathVariable long id) {
        return productService.getById(id);
    }

    @DeleteMapping("{id}")
    public Optional<Product> delete(@PathVariable long id) {
        return productService.delete(id);
    }
}

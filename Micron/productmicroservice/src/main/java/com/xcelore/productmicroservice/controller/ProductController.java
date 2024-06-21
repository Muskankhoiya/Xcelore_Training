package com.xcelore.productmicroservice.controller;


import com.xcelore.productmicroservice.entity.Product;
import com.xcelore.productmicroservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

}
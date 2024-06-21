package com.xcelore.ordermicroservice.controller;

import com.xcelore.productmicroservice.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// ProductClient.java (Feign Client for Product Service)
@FeignClient(name = "product-service", url = "http://localhost:8082")
public interface ProductClient {
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id);
}

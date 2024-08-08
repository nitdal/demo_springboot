package com.niteshdalmia.simpleWebApp.controller;

import com.niteshdalmia.simpleWebApp.model.Product;
import com.niteshdalmia.simpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/{prodId}")
    public Product getProductById(@PathVariable int prodId) {
        return service.getProductById(prodId);
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product prod) {
        service.addProduct(prod);
        return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateProduct(@RequestBody Product prod) {
        service.updateProduct(prod);
        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{prodId}")
    public ResponseEntity<String> deleteProductById(@PathVariable int prodId) {
        service.deleteProductById(prodId);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }
}

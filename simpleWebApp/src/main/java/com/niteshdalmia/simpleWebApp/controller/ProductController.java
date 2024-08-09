package com.niteshdalmia.simpleWebApp.controller;

import com.niteshdalmia.simpleWebApp.model.Product;
import com.niteshdalmia.simpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService service;

    @GetMapping
    public List<Product> getProducts() {
        logger.info("Fetching all products");
        return service.getProducts();
    }

    @GetMapping("/{prodId}")
    public ResponseEntity<Product> getProductById(@PathVariable int prodId) {
        logger.info("Fetching product with id: {}", prodId);
        Product product = service.getProductById(prodId);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product prod) {
        logger.info("Adding new product: {}", prod);
        service.addProduct(prod);
        return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateProduct(@RequestBody Product prod) {
        logger.info("Updating product: {}", prod);
        service.updateProduct(prod);
        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{prodId}")
    public ResponseEntity<String> deleteProductById(@PathVariable int prodId) {
        logger.info("Deleting product with id: {}", prodId);
        service.deleteProductById(prodId);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }
}

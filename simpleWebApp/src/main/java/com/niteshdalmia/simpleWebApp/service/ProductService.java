package com.niteshdalmia.simpleWebApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import com.niteshdalmia.simpleWebApp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.niteshdalmia.simpleWebApp.exception.ProductNotFoundException;
import com.niteshdalmia.simpleWebApp.repository.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    ProductRepo repo;

//    List<Product> products = new ArrayList<>(Arrays.asList(
//            new Product(1,"phone",5000),
//            new Product(2,"fan",1500),
//            new Product(3,"battery",150)));

    public List<Product> getProducts(){
        logger.debug("Fetching all products from the repository");
        return repo.findAll();
    }

    public Product getProductById(int prodId) {
        logger.debug("Fetching product with id: {}", prodId);
        return repo.findById(prodId)
                .orElseThrow(()->new ProductNotFoundException("Product not found with id: " + prodId));
    }

    public void addProduct(Product prod){
        logger.debug("Adding product: {}", prod);
        if (prod == null || prod.getProdName() == null || prod.getPrice() <= 0) {
            throw new IllegalArgumentException("Invalid product data");
        }
        repo.save(prod);
    }

    public void updateProduct(Product prod) {
        logger.debug("Updating product: {}", prod);
        Product existingProduct = repo.findById(prod.getProdId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + prod.getProdId()));

        repo.save(prod);
    }

    public void deleteProductById(int prodId) {
        logger.debug("Deleting product with id: {}", prodId);
        Product existingProduct = repo.findById(prodId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + prodId));

        repo.deleteById(prodId);
    }
}

package com.niteshdalmia.simpleWebApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import com.niteshdalmia.simpleWebApp.model.Product;
import org.springframework.stereotype.Service;
import com.niteshdalmia.simpleWebApp.exception.ProductNotFoundException;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1,"phone",5000),
            new Product(2,"fan",1500),
            new Product(3,"battery",150)));

    public List<Product> getProducts(){
        return products;
    }

    public Product getProductById(int prodId) {
        return products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst()
                .orElseThrow(()->new ProductNotFoundException("Product not found with id: " + prodId));
    }

    public void addProduct(Product prod){
        if (prod == null || prod.getProdName() == null || prod.getPrice() <= 0) {
            throw new IllegalArgumentException("Invalid product data");
        }
        products.add(prod);
    }

    public void updateProduct(Product prod) {
        int index = -1;
        for(int i=0;i<products.size();i++){
            if(products.get(i).getProdId() == prod.getProdId()){
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new ProductNotFoundException("Product not found with id: " + prod.getProdId());
        }
        products.set(index, prod);
    }

    public void deleteProductById(int prodId) {
        Product product = products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + prodId));
        products.remove(product);
    }
}

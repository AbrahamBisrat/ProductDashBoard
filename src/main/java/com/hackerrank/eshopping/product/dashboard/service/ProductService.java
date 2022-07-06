package com.hackerrank.eshopping.product.dashboard.service;

import com.hackerrank.eshopping.product.dashboard.exception.ProductAlreadyExistsException;
import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.model.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product addProduct(Product product) throws ProductAlreadyExistsException;
    void updateProductById(ProductDto productDto);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByCategoryAndAvailability(String category, int availability);
    List<Product> getAllProducts();
}

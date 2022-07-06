package com.hackerrank.eshopping.product.dashboard.service.Impl;

import com.hackerrank.eshopping.product.dashboard.exception.ProductAlreadyExistsException;
import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.model.dto.ProductDto;
import com.hackerrank.eshopping.product.dashboard.repository.ProductRepo;
import com.hackerrank.eshopping.product.dashboard.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override public Product addProduct(Product product) throws ProductAlreadyExistsException {
        if(productRepo.findProductByName(product.getName()).isPresent())
            throw ProductAlreadyExistsException.createWith("Product Already Exists");
        return productRepo.save(product);
    }

    @Override public void updateProductById(ProductDto productDto) {
        //
    }

    @Override public List<Product> getProductsByCategory(String category) {
        return null;
    }

    @Override public List<Product> getProductsByCategoryAndAvailability(String category, int availability) {
        return null;
    }

    @Override public List<Product> getAllProducts() {
        return null;
    }
}

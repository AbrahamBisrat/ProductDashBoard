package com.hackerrank.eshopping.product.dashboard.service.Impl;

import com.hackerrank.eshopping.product.dashboard.exception.ProductAlreadyExistsException;
import com.hackerrank.eshopping.product.dashboard.exception.ProductNotFound;
import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.model.dto.ProductDto;
import com.hackerrank.eshopping.product.dashboard.repository.ProductRepo;
import com.hackerrank.eshopping.product.dashboard.service.ProductService;
import com.hackerrank.eshopping.product.dashboard.util.ProductComparators;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override public Product addProduct(Product product) throws ProductAlreadyExistsException {
        if(productRepo.findProductByName(product.getName()).isPresent())
            throw ProductAlreadyExistsException.createWith("Product Already Exists");
        return productRepo.save(product);
    }

    @Override public void updateProductById(Long id, ProductDto productDto) {
        Product product = getProductById(id);
        product.setRetailPrice(productDto.getRetail_price());
        product.setAvailability(productDto.getAvailability());
        product.setDiscountedPrice(productDto.getDiscounted_price());
        productRepo.save(product);
    }

    @Override public List<Product> getProductsByCategory(String category) {
        List<Product> products = productRepo.getProductsByCategory(category);
        products.sort(ProductComparators.compByStockNAvailablityNPrice);
        return products;
    }

    @Override public List<Product> getProductsByCategoryAndAvailability(String category, int availability) {
        return null;
    }

    @Override public List<Product> getAllProducts() {
        return null;
    }
    @Override public Product getProductById(Long id) {
        return productRepo.findById(id).orElseThrow(()-> ProductNotFound.createWith(id));
    }
}

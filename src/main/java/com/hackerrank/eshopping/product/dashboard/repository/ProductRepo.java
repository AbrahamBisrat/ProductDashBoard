package com.hackerrank.eshopping.product.dashboard.repository;

import com.hackerrank.eshopping.product.dashboard.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
    Optional<Product> findProductById(Long id);
    Optional<Product> findProductByName(String name);
    List<Product> findProductsByCategory(String category);
    List<Product> findProductByCategoryAndAvailability(String category, Boolean available);
}

package com.hackerrank.eshopping.product.dashboard.repository;

import com.hackerrank.eshopping.product.dashboard.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
    Optional<Product> findProductByName(String name);
}
package com.hackerrank.eshopping.product.dashboard.controller;

import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.model.dto.ProductDto;
import com.hackerrank.eshopping.product.dashboard.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        productService.updateProductById(id, productDto);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(params = "category")
    public ResponseEntity<?> getProductsByCategory(@RequestParam String category) {
        return new ResponseEntity<>(productService.getProductsByCategory(category), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductByProductId(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping(params = {"category", "availability"})
    public ResponseEntity<?> getProductsByCategoryAndAvailability(@RequestParam String category,
                                                                  @RequestParam int availability) {
        return new ResponseEntity<>(productService
                .getProductsByCategoryAndAvailability(category, availability), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
}

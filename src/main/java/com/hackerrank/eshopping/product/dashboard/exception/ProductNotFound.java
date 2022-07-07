package com.hackerrank.eshopping.product.dashboard.exception;


public class ProductNotFound extends RuntimeException {
    private final Long id;
    private ProductNotFound(Long id) { this.id = id; }
    public static ProductNotFound createWith(Long id) {
        return new ProductNotFound(id);
    }
    @Override public String getMessage() { return "Product '" + id + "' Not found!"; }
}

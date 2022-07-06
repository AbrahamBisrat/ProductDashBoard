package com.hackerrank.eshopping.product.dashboard.exception;

public class ProductAlreadyExistsException extends RuntimeException {
    private final String product;
    private ProductAlreadyExistsException(String thatProduct) {
        this.product = thatProduct;
    }
    public static ProductAlreadyExistsException createWith(String product) {
        return new ProductAlreadyExistsException(product);
    }
    @Override public String getMessage() {
        return "User '" + product + "' Already exists";
    }
}

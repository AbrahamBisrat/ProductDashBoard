package com.hackerrank.eshopping.product.dashboard.model.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Double retail_price;
    private Double discounted_price;
    private Boolean availability;
}

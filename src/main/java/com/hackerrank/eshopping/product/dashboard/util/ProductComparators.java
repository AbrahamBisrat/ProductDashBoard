package com.hackerrank.eshopping.product.dashboard.util;

import com.hackerrank.eshopping.product.dashboard.model.Product;

import java.util.Comparator;
/*
 * the Json should be sorted by availability
 * in stock products must be listed before out of stock products.
 * the products with same availability status must be sorted by discounted price in the ascending order
 * finally, the products with same discounted price must be sorted by the id in the ascending order
 *
 * Comparators are needed here
 */
public class ProductComparators {
    public static Comparator<Product> compByStockNAvailablityNPrice = new Comparator<Product>() {
        @Override public int compare(Product p1, Product p2) {
            // available vs not available ( in stock must be listed before out of stock )
            // if both available -> sort by discountedPrice in ascending order
            // if both have available and have the same discounted price -> sort by id in asc

            if(p1.getAvailability() && !p2.getAvailability())
                return 1;
            else if(!p1.getAvailability() && p2.getAvailability())
                return -1;
            else if(p1.getAvailability() && p2.getAvailability()) {
                // sort by discountedPrice
                if(p1.getDiscountedPrice() != p2.getDiscountedPrice()) {
                    return (int) (p1.getDiscountedPrice() - p2.getDiscountedPrice());
                } else { // sort by id
                    return (int) (p1.getId() - p2.getId());
                }
            }
            return 0;
        }
    };
}

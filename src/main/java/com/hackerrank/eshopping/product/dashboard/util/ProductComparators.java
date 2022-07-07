package com.hackerrank.eshopping.product.dashboard.util;

import com.hackerrank.eshopping.product.dashboard.model.Product;

import java.util.Comparator;

public class ProductComparators {
    public static Comparator<Product> compByStockNAvailablityNPrice = new Comparator<Product>() {
        @Override public int compare(Product p1, Product p2) {
            // available vs not available ( in stock must be listed before out of stock )
            // if both available -> sort by discountedPrice in ascending order
            // if both have available and have the same discounted price -> sort by id in asc

            if(p1.getAvailability() && !p2.getAvailability())
                return -1;
            else if(!p1.getAvailability() && p2.getAvailability())
                return 1;
            else if(p1.getAvailability() && p2.getAvailability()) {
                // sort by discountedPrice
                if(p1.getDiscounted_price() != p2.getDiscounted_price()) {
                    return (int) (p1.getDiscounted_price() - p2.getDiscounted_price());
                } else { // sort by id
                    return (int) (p1.getId() - p2.getId());
                }
            }
            return 0;
        }
    };
    /* The list should be sorted by discount percentage in descending order.
     * products with the same discount percentage status must be sorted by the discounted price
     * in ascending order, finally the products with the same of the above should be sorted by id
     *
     * DiscountPercentage = (retailPrice - discountedPrice) / (retailPrice x 100)
     *
     */
    public static Comparator<Product> compByDiscountPercentage = new Comparator<Product>() {
        @Override public int compare(Product p1, Product p2) {
            double dp1 = ((p1.getRetail_price() - p1.getDiscounted_price()) / p1.getRetail_price()) * 100;
            double dp2 = ((p2.getRetail_price() - p2.getDiscounted_price()) / p2.getRetail_price()) * 100;

            if(dp1 != dp2) return (int) (dp2 - dp1);
            else {
                if(p1.getDiscounted_price().equals(p2.getDiscounted_price()))
                    return (int)(p1.getDiscounted_price() - p2.getDiscounted_price());
                else return (int) (p1.getId() - p2.getId());
            }
        }
    };
}

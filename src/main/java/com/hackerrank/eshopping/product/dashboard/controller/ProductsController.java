package com.hackerrank.eshopping.product.dashboard.controller;

import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductsController {
    private static void p(Object line) { System.out.println(line); }

    private final ProductService productService;

    /* add products -- if the product exists return 400, 201 otherwise */
    @PostMapping("/")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        p("Add product has been hit!");

        return new ResponseEntity<>(new Product(), HttpStatus.CREATED);
    }

    // YOU MAY OR MAY NOT RECEIVE THE ENTIRE DTO
    /* update a product by id - @/{id} -
    * update Json will be in the format of {retail_price, discounted_price, availability}
    * These values may remain unchanged
    *
    * If the product with the requested id does not exist then return 400, 200 otherwise */

    /* return the product by id @/{id}
    * if product doesn't exist return 404, 200 otherwise */

    /* return products by category, array of all the products by the given category
     * /products/?category={category}
     * response is 200;
     * the Json should be sorted by availability
     * in stock products must be listed before out of stock products.
     * the products with same availability status must be sorted by discounted price in the ascending order
     * finally, the products with same discounted price must be sorted by the id in the ascending order
     *
     * Comparators are needed here
     * */

    /* return products by category and availability. The service should be able to return
     * the JSON array of all the products by the given category and availability by the GET
     * request @ /products/?category={category}&availability={availability}
     * The response code is 200;
     * array is sorted by discount percentage in the descending order.
     * the products with the same discount percentage status must be sorted by the discounted
     * price in the ascending order. Finally, the products with same discounted percentage price
     * must be sorted by id in the ascending order.
     *
     * Discount % = (retailPrice - DiscountedPrice)/(retailPrice * 100) - guaranteed to always be in
     * */

    /* Return all products: the service should be able to return the JSON array of all products by
     * the GET request @/products.
     * the return status should be 200;
     */
}

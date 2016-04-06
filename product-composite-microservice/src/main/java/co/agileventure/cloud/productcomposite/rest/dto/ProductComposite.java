/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.productcomposite.rest.dto;

import co.agileventure.cloud.productcomposite.rest.clients.Product;
import co.agileventure.cloud.productcomposite.rest.clients.Review;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class ProductComposite {
    private Product product;
    private  List<Review> reviews;

    public ProductComposite(Product product, List<Review> reviews) {
        this.product = product;
        this.reviews = reviews;
    }

    public Product getProduct() {
        return product;
    }

   

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Review> getReviews() {
        return reviews;
    }

   
    
    
}

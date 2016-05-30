/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.productcomposite.rest;

import co.agileventure.cloud.productcomposite.rest.clients.Product;
import co.agileventure.cloud.productcomposite.rest.clients.ProductClient;
import co.agileventure.cloud.productcomposite.rest.clients.Review;
import co.agileventure.cloud.productcomposite.rest.clients.ReviewClient;
import co.agileventure.cloud.productcomposite.rest.dto.ProductComposite;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos
 */
@RestController
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@RequestMapping("/")
public class ProductCompositeController {
    private ProductClient productClient;
    private ReviewClient reviewClient;

    @Autowired
    public void setProductMicroserviceClient(ProductClient productClient,ReviewClient reviewClient) {
        this.productClient = productClient;
        this.reviewClient = reviewClient;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> findAll() {        
        return this.productClient.findAll();
    }
    
     @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ProductComposite findById(@PathVariable("id") Long id) {
        Product product = productClient.findById(id);
        List<Review> reviews = reviewClient.findByProductId(id);
        ProductComposite productComposite = new ProductComposite(product, reviews);
        return productComposite;
    }
    
}

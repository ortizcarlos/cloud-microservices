/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.product.rest;

import co.agileventure.cloud.product.domain.Product;
import co.agileventure.cloud.product.service.ProductService;
import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 *
 * @author Carlos
 */
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@RestController
@RequestMapping("/products")
public class ProductController {

    
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody @Valid Product product) {
        return productService.create(product);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        productService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> findAll() {
        return productService.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Product update(@RequestBody @Valid Product product) {
        return productService.update(product);
    }
}

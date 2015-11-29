/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.product.service;

import co.agileventure.cloud.product.domain.Product;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface ProductService {    
    Product create(Product product);
    void delete(Long id);
    List<Product> findAll();
    Product findById(Long id);
    Product update(Product product);
}

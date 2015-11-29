/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.product.repository;

import co.agileventure.cloud.product.domain.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Carlos
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
}

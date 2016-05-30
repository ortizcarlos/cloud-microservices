/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.productcomposite.rest.clients;

import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Carlos
 */
@FeignClient("PRODUCT")
public interface ProductClient {
    
   @RequestMapping(value="/", method=RequestMethod.GET) 
   List<Product> findAll();
   
   @RequestMapping(value="/{id}", method=RequestMethod.GET) 
   Product findById(@PathVariable("id")Long id);
}

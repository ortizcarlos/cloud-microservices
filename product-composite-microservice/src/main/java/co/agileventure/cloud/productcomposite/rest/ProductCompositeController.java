/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.productcomposite.rest;

import co.agileventure.cloud.productcomposite.rest.clients.ProductMicroserviceClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos
 */
@RestController
@RequestMapping("/productcomposite")
public class ProductCompositeController {
    private ProductMicroserviceClient productMicroserviceClient;

    @Autowired
    public void setProductMicroserviceClient(ProductMicroserviceClient productMicroserviceClient) {
        this.productMicroserviceClient = productMicroserviceClient;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String find() {        
        return this.productMicroserviceClient.serviceUrl();
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.productcomposite.rest.clients;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos
 */
@Service
public class ProductMicroserviceClient {

    @Autowired
    private DiscoveryClient discoveryClient;

    public String serviceUrl() {
        List<ServiceInstance> list = discoveryClient.getInstances("PRODUCT");
        if (list != null && list.size() > 0) {
            return list.get(0).getUri().toString();
        }
        return null;
    }
    
    private void getProductInfoByID(Long id) {
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.productcomposite.rest.clients;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Carlos
 */
@Component
public class ReviewClientFallback implements ReviewClient {

    @Override
    public List<Review> findByProductId(Long id) {
        return new ArrayList<Review>();
    }
    
}

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
@FeignClient("REVIEW")
public interface ReviewClient {

    @RequestMapping(value = "/review/product/{id}", method = RequestMethod.GET)
    List<Review> findByProductId(@PathVariable("id") Long id);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 *
 * @author Carlos
 */


@SpringBootApplication
@EnableDiscoveryClient
public class ReviewMicroServiceApplication {
     public static void main(String[] args) {
        SpringApplication.run(ReviewMicroServiceApplication.class, args);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.productcomposite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
/**
 *
 * @author Carlos
 */




@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients
@EnableHystrixDashboard
public class ProductCompositeApplication {
     public static void main(String[] args) {
        SpringApplication.run(ProductCompositeApplication.class, args);
    }
}

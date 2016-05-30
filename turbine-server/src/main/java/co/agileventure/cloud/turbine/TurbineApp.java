/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.turbine;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 *
 * @author Carlos
 */


@SpringBootApplication
@EnableTurbineStream
@EnableDiscoveryClient
public class TurbineApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(TurbineApp.class).run(args);
    }
}

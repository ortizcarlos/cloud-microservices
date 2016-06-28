package co.agileventure.cloud.product.config;


import co.agileventure.cloud.product.filter.JWTAuthFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class WebConfig {
    @Value("${authapp.secretkey}")
    private String secret;

    @Bean
    public FilterRegistrationBean shallowEtagHeaderFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new JWTAuthFilter(secret));
        registration.addUrlPatterns("/*");
        return registration;
    }

}

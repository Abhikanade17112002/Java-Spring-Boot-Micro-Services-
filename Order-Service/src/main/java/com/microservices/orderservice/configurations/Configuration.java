package com.microservices.orderservice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {


    @Bean
    public RestTemplate getRestTemplate(){
//        return new RestTemplate() ;

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory() ;
        factory.setConnectTimeout(1000);
        factory.setReadTimeout(5000);

        return new RestTemplate( factory ) ;
    }

    @Bean
    public RestClient getRestClient(){
        return RestClient.create() ;
    }
}

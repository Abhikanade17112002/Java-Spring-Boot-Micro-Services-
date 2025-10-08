package com.microservices.orderservice;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "order-product-service" ,
        url = "${orderproductservice.base.url}"
)
public interface ProductClient {

    @GetMapping("/products/id")
    ResponseEntity<String> getProductById(@PathVariable( name = "id") String productId ) ;
}

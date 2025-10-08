package com.microservices.orderservice.controllers;


import com.microservices.orderservice.ProductClient;
import com.microservices.orderservice.entities.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {


    private ProductClient productClient ;

    @Autowired
    private RestTemplate restTemplate ;

    @Autowired
    private RestClient restClient ;

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrder(@PathVariable(name = "id") String orderId ){
//        String response = restTemplate.getForObject("http://localhost:8082/products/" + orderId , String.class) ;
//        System.out.println("Response From Product Api Called From Order Service ==> " + response );
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(
//                        response
//                ) ;


//        String response = restClient
//                            .get()
//                .uri("http://localhost:8082/products/" + orderId)
//                .retrieve()
//                .onStatus(response1 ->{
//
//                    if( response1.getStatusCode().is2xxSuccessful() ){
//                        System.out.println("This IS A Success");
//                    }
//                    else if( response1.getStatusCode().is4xxClientError() ){
//                        System.out.println("This IS Some Client Error");
//
//                        throw new RuntimeException("This IS Some Client Error") ;
//                    }
//                    else if (response1.getStatusCode().is5xxServerError()){
//                        System.out.println("This Is Some Server Error");
//                        throw new RuntimeException("This Is Some Server Error") ;
//                    }
//
//                    return false ;
//                })
//                .body(String.class) ;

        ResponseEntity<String> response = productClient.getProductById(orderId) ;


        return response ;
    }


    @PostMapping("/createneworder")
    public ResponseEntity createNewOrder(@RequestBody Entity entity){
        System.out.println("Entity ==> " + entity );

        ResponseEntity<Entity> response = restClient
                .post()
                .uri("http://localhost:8082/products/createnewproduct")
                .accept(MediaType.APPLICATION_JSON)
                .body(entity)
                .retrieve()
                .toEntity(Entity.class) ;

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response) ;

    }
}

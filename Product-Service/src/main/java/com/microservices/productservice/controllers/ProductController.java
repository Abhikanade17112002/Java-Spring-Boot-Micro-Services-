package com.microservices.productservice.controllers;


import com.microservices.productservice.entities.Entity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public ResponseEntity<String> getProduct(@PathVariable(name = "id") String productId ){
        return ResponseEntity.status(HttpStatus.resolve(200)).body(
                "Product Information"
        ) ;
    }


    @PostMapping("/createnewproduct")
    public ResponseEntity createNewOrder(@RequestBody Entity entity){
        System.out.println("Entity ==> " + entity );

        entity.setName("Updated Name ==> " + entity.getName());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(entity) ;

    }
}

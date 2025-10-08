package com.hotelservice.controllers;

import com.hotelservice.entities.Hotel;
import com.hotelservice.services.interfaces.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService ;
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        hotelService.getAllHotels()
                ) ;
    }

    @GetMapping("/{id}")
    private ResponseEntity<Hotel> getHotelById(@PathVariable( name = "id") String hotelId ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        hotelService.getHotelById(hotelId)
                ) ;
    }

    @PostMapping
    private ResponseEntity<Hotel> addNewHotel(@RequestBody Hotel hotel ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        hotelService.addNewHotel(hotel)
                ) ;
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteHotelById(@PathVariable(name = "id") String hotelId ){

        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        hotelService.deleteHotelById(hotelId)
                ) ;
    }
}

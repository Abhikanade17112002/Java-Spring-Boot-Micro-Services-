package com.userservice.controllers;

import com.userservice.entities.Hotel;
import com.userservice.entities.Rating;
import com.userservice.entities.User;
import com.userservice.services.interfaces.HotelService;
import com.userservice.services.interfaces.RatingService;
import com.userservice.services.interfaces.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private HotelService hotelService ;

    @Autowired
    private RatingService ratingService ;

    @Autowired
    private UserService userService ;

    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody User user ){

        User createdUser = userService.AddNewUser( user ) ;

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        createdUser
                ) ;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> retrivedUsers = userService.getAllUsers() ;

        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        retrivedUsers
                ) ;
    }

    @GetMapping("/{id}")
//    @CircuitBreaker(name = "userServiceCircuitBreaker" ,fallbackMethod = "userServiceCircuitBreakerFallBack")
//    @Retry(name = "userServiceRetry" ,fallbackMethod = "userServiceRetryFallBack")
    @RateLimiter(name = "userServiceRateLimiter" ,fallbackMethod = "userServiceRateLimiterFallBack")
    public ResponseEntity<User> getUserById(@PathVariable(name = "id") String userId ){
        User retrivedUser = userService.getUserById( userId ) ;

        List<Rating> retrivedUserRatings = ratingService.getListOfUserRatings( retrivedUser.getUserId() ) ;

        retrivedUserRatings = retrivedUserRatings.stream()
                .map(rating -> {
                    Hotel hotel = hotelService.getHotelById(rating.getHotelId());
                    rating.setHotel(hotel);
                    return rating; // return the updated object
                })
                .collect(Collectors.toList());

        retrivedUser.setRatings(retrivedUserRatings);

        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        retrivedUser
                ) ;
    }

    public ResponseEntity<User> userServiceCircuitBreakerFallBack(String userId , Exception e ){
        System.out.println("Some Exception Occured Due To Service Down ==> " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        new User()
                ) ;
    }


    public ResponseEntity<User> userServiceRetryFallBack(String userId , Exception e ){
        System.out.println("Some Exception Occured Due To Service Down Did Not Respond With 3 Retry Attempts==>  " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        new User()
                ) ;
    }



    public ResponseEntity<User> userServiceRateLimiterFallBack(String userId , Exception e ){
        System.out.println(
                "Some Exception Occured Due To Service Excessive Number Of Request Send By Teh Client Attempts==> "

                   + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        new User()
                ) ;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable(name = "id") String userId ){
        String response = userService.deleteUserById( userId ) ;

        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        response
                ) ;
    }
}

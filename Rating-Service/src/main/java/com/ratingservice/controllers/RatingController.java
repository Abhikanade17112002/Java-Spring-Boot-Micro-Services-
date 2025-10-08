package com.ratingservice.controllers;

import com.ratingservice.entities.Rating;
import com.ratingservice.services.implementations.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    // ✅ 1. Get all ratings
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    // ✅ 2. Get rating by ID
    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRatingById(@PathVariable String ratingId) {
        return ResponseEntity.ok(ratingService.getRatingById(ratingId));
    }

    // ✅ 3. Get ratings by userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUser(@PathVariable String userId) {
        return ResponseEntity.ok(ratingService.getUsersRatingById(userId));
    }

    // ✅ 4. Get ratings by hotelId
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotel(@PathVariable String hotelId) {
        return ResponseEntity.ok(ratingService.getHotelsRatingsById(hotelId));
    }

    // ✅ 5. Add a new rating
    @PostMapping
    public ResponseEntity<Rating> addNewRating(@RequestBody Rating rating) {
        System.out.println("Received Rating ==> " + rating);
        Rating savedRating = ratingService.addNewRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
    }

    // ✅ 6. Delete a rating
    @DeleteMapping("/{ratingId}")
    public ResponseEntity<String> deleteRating(@PathVariable String ratingId) {
        String response = ratingService.deleteRatingById(ratingId);
        return ResponseEntity.ok(response);
    }
}

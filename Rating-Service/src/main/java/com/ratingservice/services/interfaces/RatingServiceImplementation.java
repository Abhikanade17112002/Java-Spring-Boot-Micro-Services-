package com.ratingservice.services.interfaces;

import com.ratingservice.entities.Rating;
import com.ratingservice.repositories.RatingRepository;
import com.ratingservice.services.implementations.RatingService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
@Service  // ✅ Make it a Spring-managed bean
public class RatingServiceImplementation implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    // ✅ Get all ratings
    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    // ✅ Get rating by ID
    @Override
    public Rating getRatingById(String ratingId) {
        return ratingRepository.findById(ratingId)
                .orElseThrow(() -> new RuntimeException("Rating not found with ID: " + ratingId));
    }

    // ✅ Get all ratings by userId
    @Override
    public List<Rating> getUsersRatingById(String userId) {
        return ratingRepository.findByUserId(userId).orElseThrow(
                ()-> new EntityNotFoundException("Rating Associated With User Id " + userId + " Not Found ")
        );
    }

    // ✅ Get all ratings by hotelId
    @Override
    public List<Rating> getHotelsRatingsById(String hotelId) {
        return ratingRepository.findByHotelId(hotelId).orElseThrow(()-> new EntityNotFoundException("Rating Associated With Hotel Id " + hotelId + " Not Found "));
    }

    // ✅ Add a new rating
    @Override
    public Rating addNewRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    // ✅ Delete rating by ID
    @Override
    public String deleteRatingById(String ratingId) {
        ratingRepository.deleteById(ratingId);
        return "Rating with ID " + ratingId + " deleted successfully!";
    }
}

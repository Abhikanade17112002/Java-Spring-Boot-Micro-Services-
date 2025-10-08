package com.ratingservice.services.implementations;


import com.ratingservice.entities.Rating;

import java.util.List;

public interface RatingService {
    // GET ALL RATINGS
    List<Rating> getAllRatings() ;
    // GET RATING BY ID
    Rating getRatingById( String ratingId ) ;
    // GET ALL RATINGS OF USER BY USER ID
    List<Rating> getUsersRatingById(String userId);
    // GET ALL RATING OF HOTEL BY ID
    List<Rating> getHotelsRatingsById( String hotelId) ;
    // CREATE NEW RATING
    Rating addNewRating( Rating rating) ;
    // DELETE RATING BY ID
    String deleteRatingById( String ratingId );
}

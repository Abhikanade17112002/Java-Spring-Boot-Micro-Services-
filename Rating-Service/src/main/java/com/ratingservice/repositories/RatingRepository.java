package com.ratingservice.repositories;

import com.ratingservice.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating,String> {
    Optional<List<Rating>> findByUserId(String userId) ;
    Optional<List<Rating>> findByHotelId(String hotelId) ;
}

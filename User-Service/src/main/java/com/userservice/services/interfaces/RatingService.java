package com.userservice.services.interfaces;

import com.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "RATING-SERVICE"
)
public interface RatingService {

    @GetMapping("/ratings/user/{id}")
    public List<Rating> getListOfUserRatings(@PathVariable( name = "id") String userId ) ;
}

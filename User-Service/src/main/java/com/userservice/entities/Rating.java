package com.userservice.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Rating {
    private String ratingId ;
    private String userId ;
    private String hotelId ;
    private String feedback ;
    private Hotel hotel ;
}

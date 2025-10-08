package com.ratingservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ratings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ratingId ;
    @Column(nullable = false)
    private String userId ;
    @Column(nullable = false)
    private String hotelId ;
    @Column(nullable = false)
    private String feedback ;
}

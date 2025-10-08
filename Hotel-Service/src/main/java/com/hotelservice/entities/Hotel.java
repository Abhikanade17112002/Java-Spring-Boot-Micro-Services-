package com.hotelservice.entities;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table( name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private String hotelId ;

    @Column( nullable = false )
    private String hotelName ;

    @Column( nullable = false )
    private String location ;

    @Column( nullable = false )
    private String about ;
}

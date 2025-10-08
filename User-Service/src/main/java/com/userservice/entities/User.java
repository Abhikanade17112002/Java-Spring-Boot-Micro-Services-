package com.userservice.entities;

import com.userservice.types.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table( name = "user")
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private String userId ;

    @Column( nullable = false )
    private String firstName ;

    @Column(nullable = false)
    private String lastName ;

    @Column( nullable = false , unique = true )
    private String email ;

    @Column( nullable = false )
    @Enumerated( EnumType.STRING)
    private Gender gender ;
    @Transient
    private List<Rating> ratings = new ArrayList<>() ;
}

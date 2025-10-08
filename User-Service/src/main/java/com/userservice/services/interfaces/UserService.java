package com.userservice.services.interfaces;


import com.userservice.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    // GET ALL USERS
    List<User> getAllUsers() ;

    // GET USER BY ID
    User getUserById( String userId) ;

    // ADD NEW USER
    User AddNewUser( User user ) ;

    // UPDATE USER BY ID
    User updateUserById( String userId , User updatedUser ) ;

    // DELETE USER BY ID
    String deleteUserById( String userId ) ;

}

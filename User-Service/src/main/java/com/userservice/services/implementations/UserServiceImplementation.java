package com.userservice.services.implementations;

import com.userservice.entities.User;
import com.userservice.repositories.UserRepository;
import com.userservice.services.interfaces.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository ;
    @Override
    public User AddNewUser(User user) {

        System.out.println("Received User ==>  " + user);
        return userRepository.save(user) ;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> retrivedUsers = userRepository.findAll() ;
        return retrivedUsers ;
    }

    @Override
    public User getUserById(String userId) {

        System.out.println("Received User Id ==> " + userId);

        User retrivedUser = userRepository.findById(userId).orElseThrow(()-> new EntityNotFoundException("User Entity Not Found On Server Having Id ==> " + userId)) ;

        return retrivedUser ;
    }

    @Override
    public User updateUserById(String userId, User updatedUser) {
        return null;
    }

    @Override
    public String deleteUserById(String userId) {
        System.out.println("Received User Id ==> " + userId);

        userRepository.deleteById(userId) ;

        String response =   "Deleted User Having User Id " + userId ;

        return response ;
    }
}

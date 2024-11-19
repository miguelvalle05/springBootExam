package com.example.hackerrank.Service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.hackerrank.Model.User;
import com.example.hackerrank.Repository.UserRepository;

@Service
public class UserService {
    
   private final UserRepository userRepository;

   
   public UserService (UserRepository userRepository){
    this.userRepository= userRepository;
   /*userRepository.addUser(new User("Ana Gómez", "ana.gomez@example.com"));
    userRepository.addUser(new User("Carlos López", "carlos.lopez@example.com"));
    userRepository.addUser(new User("Ana Gómez", "ana.gomez@example.com"));
    userRepository.addUser(new User("María Rodríguez", "maria.rodriguez@example.com"));*/
    
   }

   public List<User> getAllUsers(){
        return userRepository.getAllUsers();
   }

}

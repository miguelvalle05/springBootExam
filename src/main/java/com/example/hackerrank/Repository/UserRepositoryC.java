package com.example.hackerrank.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.hackerrank.Model.User;

@Repository
public class UserRepositoryC   {

    final List<User> users= new ArrayList<>();

   

    public void addUser(User user){
        users.add(user);
    }

    public List<User> getAllUsers(){
        return users;
    }


    
}

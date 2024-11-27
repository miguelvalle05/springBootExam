package com.example.hackerrank.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackerrank.Model.User;
import com.example.hackerrank.Service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController (UserService userService){
        this.userService=userService;
    }

    //Crear nuevo usuario
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser= userService.createUser(user);
        return new ResponseEntity<> (createdUser, HttpStatus.CREATED);
    }

    // Obtener todos los usuarios
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    //Actualizar un usuario
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@ RequestBody User user){
        User updatedUser = userService.updateUser(id, user);
        return updatedUser != null ? ResponseEntity.ok(updatedUser): ResponseEntity.notFound().build();
    }

    //Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id) ? ResponseEntity.noContent().build(): ResponseEntity.notFound().build();

    }
    
}

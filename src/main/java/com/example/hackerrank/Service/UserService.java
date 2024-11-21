package com.example.hackerrank.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.hackerrank.Model.User;
import com.example.hackerrank.Repository.UserRepository;
import com.example.hackerrank.Repository.UserRepositoryC;

@Service
public class UserService {
    
   private final UserRepositoryC userRepositoryc;
   private final UserRepository userRepository;


   
   public UserService (UserRepositoryC userRepositoryc, UserRepository userRepository){
    this.userRepositoryc= userRepositoryc;
    this.userRepository= userRepository;
   /*userRepository.addUser(new User("Ana Gómez", "ana.gomez@example.com"));
    userRepository.addUser(new User("Carlos López", "carlos.lopez@example.com"));
    userRepository.addUser(new User("Ana Gómez", "ana.gomez@example.com"));
    userRepository.addUser(new User("María Rodríguez", "maria.rodriguez@example.com"));*/
    
   }

   public List<User> getAllUsers(){
        return userRepositoryc.getAllUsers();
   }

   //Crear usuario
   public User createUser(User user){
      return userRepository.save(user);

   }

   public List<User> getAllUsersjpa(){
      return userRepository.findAll();
   }

   //Obtener un usuario por id
   public Optional<User> getUserById(Long id){
      return userRepository.findById(id);

   }

   //Actualizar usuario existente
   public User updateUser(Long id, User user){
      if(userRepository.existsById(id)){
         user.setId(id);
         return userRepository.save(user);

      }else{
         return null;
      }

   }

   //eliminar un usario

   public boolean deleteUser(Long id){
      if(userRepository.existsById(id)){
         userRepository.deleteById(id);
         return true;

      }else{
         return false;
      }

   }
}

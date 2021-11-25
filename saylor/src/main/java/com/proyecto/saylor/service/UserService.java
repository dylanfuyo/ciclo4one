package com.proyecto.saylor.service;


import java.util.List;
import java.util.Optional;

import com.proyecto.saylor.model.User;
import com.proyecto.saylor.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author BrayandFuyo
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Transactional (readOnly = true)
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Transactional (readOnly = true)
    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    public User registrar(User user) {
        if (user.getId() == null) {
            return userRepository.save(user);
            // if (existeEmail(user.getEmail()) == false) {
            //     return userRepository.save(user);
            // } else {
            //     return user;
            // }
        } else {
            // return user;
            return userRepository.save(user);
        }
    }

    @Transactional 
    public void deleteUser(int id){
        userRepository.delete(id);
    }


    @Transactional (readOnly = true)
    public User getByEmail(String  userEmail){        
        // if(UserRepository.getByUserEmail(userEmail)==null){
        //     return false;
        // }
        // return true;  
        return userRepository.existeEmail(userEmail)      ;
    }

    public User getByEmailAndPassword(String email,String password){
        User g=userRepository.autenticarUsuario(email, password);
        User user = new User();
        
        if(g==null){            
            user.setName("NO DEFINIDO");
            user.setPassword(password);
            user.setEmail(email);  
            return user;         
        }
        return g;
        
           
    }

    // public boolean existeEmail(String email) {
    //     return userRepository.existeEmail(email);
    // }

    // public User autenticarUsuario(String email, String password) {
    //     Optional<User> usuario = userRepository.autenticarUsuario(email, password);

    //     if (usuario.isEmpty()) {
    //         return new User(email, password, "NO DEFINIDO");
    //     } else {
    //         return usuario.get();
    //     }
    // }
}

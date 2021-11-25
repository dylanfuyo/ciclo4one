package com.proyecto.saylor.controller;


import java.util.List;

import com.proyecto.saylor.model.User;
import com.proyecto.saylor.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 */

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")

public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user) {
        return userService.registrar(user);
    }
    
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.getByEmailAndPassword(email, password);
    }
    
    @GetMapping("/{user_email}")
    public boolean getByUserEmail(@PathVariable("user_email") String email){//toma como variable lo que llega en la ruta
        
            if(userService.getByEmail(email)== null){
                return false;
            }
            return true;
        }
    // @GetMapping("/{email}")
    // public boolean existeEmail(@PathVariable("email") String email) {
    //     return userService.existeEmail(email);
    // }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//status 201
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/";
    }
}

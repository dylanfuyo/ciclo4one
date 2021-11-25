package com.proyecto.saylor.repository;

import java.util.List;
import java.util.Optional;

import com.proyecto.saylor.model.User;
import com.proyecto.saylor.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author BrayandFuyo
 */
@Repository
public class UserRepository {
    
    @Autowired
    private UserCrudRepository userCrudRepository;
    
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public User save(User user) {
        return userCrudRepository.save(user);
    }

    public void delete(int id){
        userCrudRepository.deleteById(id);        
    }

    public User existeEmail(String email){
        return userCrudRepository.findByEmail(email);
    }

    // public boolean existeEmail(String email) {
    //     Optional<User> usuario = userCrudRepository.findByEmail(email);

    //     return !usuario.isEmpty();
    // }

    public User autenticarUsuario(String email,String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    // public Optional<User> autenticarUsuario(String email, String password) {
    //     return userCrudRepository.findByEmailAndPassword(email, password);
    // }


}

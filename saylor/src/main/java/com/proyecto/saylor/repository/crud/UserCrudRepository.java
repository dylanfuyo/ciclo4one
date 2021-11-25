package com.proyecto.saylor.repository.crud;

// import java.util.Optional;
import com.proyecto.saylor.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author BrayandFuyo
 */
//Interfaz
public interface UserCrudRepository extends CrudRepository<User, Integer>{
    public User findByEmail(String email);

    @Query("select u from User u where u.email = :email and u.password = :password")
    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
    // Optional<User> findByEmailAndPassword(String email,String password);
    //Optional<User> findByName(String name);

    
}

package com.example.streamXpress.repository;

import com.example.streamXpress.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long>{

    @Query("SELECT u FROM User u WHERE u.userName =:uN")
    User findByUserName(@Param("uN") String userName);
}

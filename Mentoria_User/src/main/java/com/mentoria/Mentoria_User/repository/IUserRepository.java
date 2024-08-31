package com.mentoria.Mentoria_User.repository;

import com.mentoria.Mentoria_User.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    User findByUserRA(String usernameRA);

    Optional<User> findByUserEmail(String email);

    @Modifying
    @Query("UPDATE User u SET u.userName = :nome, u.userEmail = :email WHERE u.userId = :id")
    void updateProfile(@Param("id") Long id, @Param("nome") String nome, @Param("email") String email);

    @Modifying
    @Query("UPDATE User u SET u.userStatus = 0 WHERE u.userId = :id")
    void deactivationProfile(@Param("id") Long id);

    @Modifying
    @Query("UPDATE User u SET u.userPassword = :password WHERE u.userId = :id")
    void updatePassword(@Param("id") Long id, @Param("password") String password );


}

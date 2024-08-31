package com.mentoria.Mentoria_User.repository;

import com.mentoria.Mentoria_User.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    User findByName(String username);

    @Query("UPDATE User u SET u.userName = :nome, u.userEmail = :email WHERE u.userId = :id")
    User updateProfile(@Param("id") Long id, @Param("nome") String nome, @Param("email") String email);

    @Query("UPDATE User u SET u.userStatus = false WHERE u.userId = :id")
    User deactivationProfile(@Param("id") Long id);

    @Query("UPDATE User u SET u.userPassword = :password WHERE u.userId = :id")
    User updatePassword(@Param("id") Long id, @Param("password") String password );
}

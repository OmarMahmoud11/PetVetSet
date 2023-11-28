package com.example.PVSSpringBoot.repositories;

import com.example.PVSSpringBoot.Entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public interface UsersRepo extends CrudRepository<User,Long>  {

    @Transactional
    @Modifying
    @Query("update User u set u.password = ?1 where u.email like ?2 and u.password like ?3")
    void changePassword(String newPassword, String email, String oldPassword);
    @Transactional
    @Modifying
    @Query("update User u set u.email = ?1 where u.email like ?2")
    void updateEmail(String newEmail, String email1);

    Optional<User> findByEmail(String email);

    @Query("select u from User u where u.is_admin = true")
    List<User> findAdmins();

    @Query("select u from User u where u.is_admin = false")
    List<User> findNormalUsers();

    @Query("select u from User u where u.password is null")
    List<User> findNonNativeUsers();

    @Query("select u from User u where u.password is not null")
    List<User> findNativeUsers();




    @Transactional
    @Modifying
    @Query("delete from User u where u.email like ?1")
    void deleteByEmail(String email);




}

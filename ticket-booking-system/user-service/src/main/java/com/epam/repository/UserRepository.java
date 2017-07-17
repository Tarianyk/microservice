package com.epam.repository;

import com.epam.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Query("select user from User user where user.name like %:name%")
    List<User> findUsersByName(@Param("name") String name, Pageable pageable);
}

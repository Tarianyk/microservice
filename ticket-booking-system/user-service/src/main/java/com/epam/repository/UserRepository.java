package com.epam.repository;

import com.epam.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    List<User> findUsersByNameContaining(@Param("name") String name, Pageable pageable);

    @Modifying
    @Query("update User u set u.name = ?1, u.email = ?2 where u.id = ?3")
    User updateUser(String name, String email, long id);
}

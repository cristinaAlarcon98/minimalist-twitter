package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.model.Follow;
import com.example.model.User;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {

    @Query("SELECT f.followed FROM Follow f WHERE f.follower.id = :followerId")
    List<User> findFollowedUsersByUserId(@Param("followerId") Long followerId);

}
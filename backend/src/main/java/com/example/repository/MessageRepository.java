package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Message;
import com.example.model.User;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByUserInOrderByCreatedAtDesc(List<User> userList);
}
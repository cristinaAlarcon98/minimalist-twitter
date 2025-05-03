package com.example.controller;

import com.example.dto.UserDTO;
import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Value("${app.default.username}")
    private String loggedUser;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/following")
    public ResponseEntity<List<UserDTO>> getFollowing() {
        try {
            List<User> followingUsers = userService.getFollowedUserList(loggedUser);

            List<UserDTO> followingUserDTOs = followingUsers.stream()
                    .map(UserMapper::toDto)
                    .toList();
            return ResponseEntity.ok(followingUserDTOs);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/not-following")
    public ResponseEntity<List<UserDTO>> getNotFollowing() {
        try {
            List<User> notFollowingUsers = userService.getNotFollowedUserList(loggedUser);

            List<UserDTO> notFollowingUserDTOs = notFollowingUsers.stream()
                    .map(UserMapper::toDto)
                    .toList();

            return ResponseEntity.ok(notFollowingUserDTOs);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @Transactional
    @PostMapping("/follow/{username}")
    public ResponseEntity<String> followUser(@PathVariable String username) {
        try {
            userService.followUser(loggedUser, username);
            return ResponseEntity.ok("Successfully followed " + username);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Transactional
    @PostMapping("/unfollow/{username}")
    public ResponseEntity<String> unfollowUser(@PathVariable String username) {
        try {
            userService.unfollowUser(loggedUser, username);
            return ResponseEntity.ok("Successfully unfollowed " + username);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

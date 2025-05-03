package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("User not found with username: " + username);
        }
        return user;
    }

    public List<User> getFollowedUserList(String username) {
        User loggedInUser = userRepository.findByUsername(username);
        if (loggedInUser == null) {
            throw new IllegalArgumentException("Logged-in user not found.");
        }

        return new ArrayList<>(loggedInUser.getFollowing());
    }

    public List<User> getNotFollowedUserList(String username) {
        User loggedUser = userRepository.findByUsername(username);
        if (loggedUser == null) {
            throw new IllegalArgumentException("Logged-in user not found.");
        }

        return userRepository.findAll()
                .stream()
                .filter(user -> !loggedUser.getFollowing().contains(user) && !user.getUsername().equals(username))
                .collect(Collectors.toList());
    }

    public void followUser(String loggedUser, String username) {
        User loggedInUser = userRepository.findByUsername(loggedUser);
        if (loggedInUser == null) {
            throw new IllegalArgumentException("Logged-in user not found.");
        }

        if (loggedUser.equals(username)) {
            throw new IllegalArgumentException("A user cannot follow itself.");
        }

        User userToFollow = userRepository.findByUsername(username);
        if (userToFollow == null) {
            throw new IllegalArgumentException("User to follow not found.");
        }

        loggedInUser.getFollowing().add(userToFollow);
        userRepository.save(loggedInUser);
    }

    public void unfollowUser(String loggedUser, String username) {
        User loggedInUser = userRepository.findByUsername(loggedUser);
        if (loggedInUser == null) {
            throw new IllegalArgumentException("Logged-in user not found.");
        }

        if (loggedUser.equals(username)) {
            throw new IllegalArgumentException("A user cannot unfollow itself.");
        }

        User userToUnfollow = userRepository.findByUsername(username);
        if (userToUnfollow == null) {
            throw new IllegalArgumentException("User to unfollow not found.");
        }

        loggedInUser.getFollowing().remove(userToUnfollow);
        userRepository.save(loggedInUser);
    }
}

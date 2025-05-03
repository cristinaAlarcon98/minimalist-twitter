package com.example.dto;

import java.util.List;

public class UserDTO {
    private Long id;
    private String username;
    private List<Long> following; // Changed to List<Long> to represent IDs
    private List<Long> followed; // Changed to List<Long> to represent IDs

    // Constructor for id and username only
    public UserDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    // Constructor for all fields
    public UserDTO(Long id, String username, List<Long> following, List<Long> followed) {
        this.id = id;
        this.username = username;
        this.following = following;
        this.followed = followed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Long> getFollowing() {
        return following;
    }

    public void setFollowing(List<Long> following) {
        this.following = following;
    }

    public List<Long> getFollowed() {
        return followed;
    }

    public void setFollowed(List<Long> followed) {
        this.followed = followed;
    }
}
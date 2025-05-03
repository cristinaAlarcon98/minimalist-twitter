package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCanFollowUser() {
        User loggedUser = new User("Alice");
        User userToFollow = new User("Bob");
        when(userRepository.findByUsername("Alice")).thenReturn(loggedUser);
        when(userRepository.findByUsername("Bob")).thenReturn(userToFollow);

        userService.followUser("Alice", "Bob");

        assertTrue(loggedUser.getFollowing().contains(userToFollow));
        verify(userRepository, times(1)).findByUsername("Alice");
        verify(userRepository, times(1)).findByUsername("Bob");
        verify(userRepository, times(1)).save(loggedUser);
    }

    @Test
    void testCanUnfollowUser() {
        User loggedUser = new User("Alice");
        User userToUnfollow = new User("Bob");
        when(userRepository.findByUsername("Alice")).thenReturn(loggedUser);
        when(userRepository.findByUsername("Bob")).thenReturn(userToUnfollow);

        userService.unfollowUser("Alice", "Bob");

        assertFalse(loggedUser.getFollowing().contains(userToUnfollow));
        verify(userRepository, times(1)).findByUsername("Alice");
        verify(userRepository, times(1)).findByUsername("Bob");
        verify(userRepository, times(1)).save(loggedUser);
    }

    @Test
    void testCannotFollowYourself() {
        User loggedUser = new User("Bob");
        when(userRepository.findByUsername("Bob")).thenReturn(loggedUser);

        assertThrows(IllegalArgumentException.class, () -> userService.followUser("Bob", "Bob"));
        verify(userRepository, times(1)).findByUsername("Bob");
        verify(userRepository, never()).save(any());
    }

    @Test
    void testCannotUnfollowYourself() {
        User loggedUser = new User("Bob");
        when(userRepository.findByUsername("Bob")).thenReturn(loggedUser);

        assertThrows(IllegalArgumentException.class, () -> userService.unfollowUser("Bob", "Bob"));
        verify(userRepository, times(1)).findByUsername("Bob");
        verify(userRepository, never()).save(any());
    }

    @Test
    void testFollowUser_UserToFollowNotFound() {
        User loggedUser = new User("Bob");
        when(userRepository.findByUsername("Bob")).thenReturn(loggedUser);
        when(userRepository.findByUsername("nonExistentUser")).thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> userService.followUser("Bob", "nonExistentUser"));
        verify(userRepository, times(1)).findByUsername("Bob");
        verify(userRepository, times(1)).findByUsername("nonExistentUser");
        verify(userRepository, never()).save(any());
    }

    @Test
    void testUnfollowUser_UserToUnfollowNotFound() {
        User loggedUser = new User("Bob");
        when(userRepository.findByUsername("Bob")).thenReturn(loggedUser);
        when(userRepository.findByUsername("nonExistentUser")).thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> userService.unfollowUser("Bob", "nonExistentUser"));
        verify(userRepository, times(1)).findByUsername("Bob");
        verify(userRepository, times(1)).findByUsername("nonExistentUser");
        verify(userRepository, never()).save(any());
    }

    @Test
    void testFindUserByUsername_UserExists() {
        User mockUser = new User("Alice");
        when(userRepository.findByUsername("Alice")).thenReturn(mockUser);

        User result = userService.findUserByUsername("Alice");

        assertEquals("Alice", result.getUsername());
        verify(userRepository, times(1)).findByUsername("Alice");
    }
}

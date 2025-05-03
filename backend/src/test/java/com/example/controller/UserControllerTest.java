package com.example.controller;

import com.example.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(userController, "loggedUser", "Cristinaalarcon");
    }

    @Test
    void testFollowUser_Success() {
        String usernameToFollow = "Bob";

        doNothing().when(userService).followUser("Cristinaalarcon", usernameToFollow);

        ResponseEntity<String> response = userController.followUser(usernameToFollow);

        assertEquals(200, response.getStatusCode().value());
        assertEquals("Successfully followed " + usernameToFollow, response.getBody());
        verify(userService, times(1)).followUser("Cristinaalarcon", usernameToFollow);
    }

    @Test
    void testFollowUser_Failure_SelfFollow() {
        String usernameToFollow = "Cristinaalarcon";
        String errorMessage = "A user cannot follow itself.";

        doThrow(new IllegalArgumentException(errorMessage)).when(userService).followUser("Cristinaalarcon",
                usernameToFollow);

        ResponseEntity<String> response = userController.followUser(usernameToFollow);

        assertEquals(400, response.getStatusCode().value());
        assertEquals(errorMessage, response.getBody());
        verify(userService, times(1)).followUser("Cristinaalarcon", usernameToFollow);
    }

    @Test
    void testFollowUser_Failure() {
        String usernameToFollow = "invalidUser";
        String errorMessage = "User to follow not found.";

        doThrow(new IllegalArgumentException(errorMessage)).when(userService).followUser("Cristinaalarcon",
                usernameToFollow);

        ResponseEntity<String> response = userController.followUser(usernameToFollow);

        assertEquals(400, response.getStatusCode().value());
        assertEquals(errorMessage, response.getBody());
        verify(userService, times(1)).followUser("Cristinaalarcon", usernameToFollow);
    }

    @Test
    void testUnfollowUser_Success() {
        String usernameToUnfollow = "Bob";

        doNothing().when(userService).unfollowUser("Cristinaalarcon", usernameToUnfollow);

        ResponseEntity<String> response = userController.unfollowUser(usernameToUnfollow);

        assertEquals(200, response.getStatusCode().value());
        assertEquals("Successfully unfollowed " + usernameToUnfollow, response.getBody());
        verify(userService, times(1)).unfollowUser("Cristinaalarcon", usernameToUnfollow);
    }

    @Test
    void testUnfollowUser_Failure() {
        String usernameToUnfollow = "cristina98";
        String errorMessage = "User to unfollow not found.";

        doThrow(new IllegalArgumentException(errorMessage)).when(userService).unfollowUser("Cristinaalarcon",
                usernameToUnfollow);

        ResponseEntity<String> response = userController.unfollowUser(usernameToUnfollow);

        assertEquals(400, response.getStatusCode().value());
        assertEquals(errorMessage, response.getBody());
        verify(userService, times(1)).unfollowUser("Cristinaalarcon", usernameToUnfollow);
    }
}
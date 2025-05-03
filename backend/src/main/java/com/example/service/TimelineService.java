package com.example.service;

import java.util.List;
import com.example.dto.MessageDTO;
import com.example.model.User;
import org.springframework.stereotype.Service;

@Service
public class TimelineService {

    private final MessageService messageService;
    private final UserService userService;

    public TimelineService(
            MessageService messageService,
            UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    public List<MessageDTO> getTimeline(String username) {

        User loggedUser = userService.findUserByUsername(username);

        List<User> userList = userService.getFollowedUserList(loggedUser.getUsername());

        if (userList.isEmpty()) {
            return getFilteredTimeline(loggedUser.getUsername());
        }
        userList.add(loggedUser);

        return messageService.findMessages(userList);
    }

    public List<MessageDTO> getFilteredTimeline(String username) {
        User user = userService.findUserByUsername(username);
        return messageService.findMessages(List.of(user));
    }

}
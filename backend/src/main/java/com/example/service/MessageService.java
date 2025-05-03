package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.dto.MessageDTO;
import com.example.mapper.MessageMapper;
import com.example.model.Message;
import com.example.model.User;
import com.example.repository.MessageRepository;
import org.springframework.http.ResponseEntity;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    private final MessageMapper messageMapper;

    private final UserService userService;

    public MessageService(MessageRepository messageRepository, MessageMapper messageMapper, UserService userService) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
        this.userService = userService;
    }

    public List<MessageDTO> findMessages(List<User> usersList) {

        List<Message> messages = messageRepository.findByUserInOrderByCreatedAtDesc(usersList);
        if (messages.isEmpty()) {
            return new ArrayList<>();
        }
        return messages.stream()
                .map(message -> {
                    MessageDTO dto = messageMapper.toDto(message);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public ResponseEntity<Void> postMessage(String loggedUser, String messageContent) {
        try {
            User user = userService.findUserByUsername(loggedUser);
            Message message = new Message();
            message.setContent(messageContent);
            message.setUser(user);
            messageRepository.save(message);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}

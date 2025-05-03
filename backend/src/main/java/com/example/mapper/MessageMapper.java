package com.example.mapper;

import org.springframework.stereotype.Component;
import com.example.dto.MessageDTO;
import com.example.model.Message;

@Component
public class MessageMapper {

    public MessageDTO toDto(Message message) {
        return new MessageDTO(
                message.getId(),
                message.getContent(),
                message.getUser().getUsername(),
                message.getCreatedAt());

    }
}

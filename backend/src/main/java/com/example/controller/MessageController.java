package com.example.controller;

import com.example.dto.MessageDTO;
import com.example.service.TimelineService;
import com.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/messages")
public class MessageController {

    @Autowired
    private TimelineService timelineService;

    @Autowired
    private MessageService messageService;

    @Value("${app.default.username}")
    private String loggedUser;

    @GetMapping("/timeline")
    public ResponseEntity<List<MessageDTO>> getTimeline() {
        try {
            List<MessageDTO> timeline = timelineService.getTimeline(loggedUser);
            return ResponseEntity.ok(timeline);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<MessageDTO>> getMessagesByUser(@PathVariable String username) {
        try {
            List<MessageDTO> userMessages = timelineService.getFilteredTimeline(username);
            return ResponseEntity.ok(userMessages);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> postMessage(@RequestBody String messageContent) {
        try {
            messageService.postMessage(loggedUser, messageContent);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
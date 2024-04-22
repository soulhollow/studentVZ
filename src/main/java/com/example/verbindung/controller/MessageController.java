package com.example.verbindung.controller;
import com.example.verbindung.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.verbindung.model.Message;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/post")
    public ResponseEntity<Message> postMessage(@RequestBody Message message) {
        System.out.println("post API called" + message.toString());
        Message postedMessage = messageService.postMessage(message);
        return new ResponseEntity<>(postedMessage, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messages = messageService.findAllMessages();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Message>> getMessagesByUserId(@PathVariable Long userId) {
        List<Message> messages = messageService.findMessagesByUserId(userId);
        if (messages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }


}

package com.example.verbindung.service;
import com.example.verbindung.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Transactional
    public Message postMessage(Message message) {
        message.setTimestamp(LocalDateTime.now()); // Setze den Zeitstempel beim Erstellen der Nachricht
        return messageRepository.save(message);
    }

    public List<Message> findAllMessages() {
        return messageRepository.findAll();
    }

    public List<Message> findMessagesByUserId(Long userId) {
        return messageRepository.findByUserId(userId);
    }

}

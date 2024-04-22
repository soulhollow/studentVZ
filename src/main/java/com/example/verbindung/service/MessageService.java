package com.example.verbindung.service;
import com.example.verbindung.UserContext;
import com.example.verbindung.model.User;
import com.example.verbindung.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.verbindung.model.Message;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private UserContext userContext= new UserContext();

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;

    }

    @Transactional
    public Message postMessage(Message message) {
        message.setTimestamp(LocalDateTime.now());
        System.out.println("postMessage entered");
        // Setze den Zeitstempel beim Erstellen der Nachricht
        /*if(userContext.getLoggedInUser()!=null){
            message.setUser(userContext.getLoggedInUser());
        }else{message.setUser(new User("t6est","46","test46"));}*/
        return messageRepository.save(message);
    }

    public List<Message> findAllMessages() {
        return messageRepository.findAll();
    }

    public List<Message> findMessagesByUserId(Long userId) {
        return messageRepository.findByUserId(userId);
    }

}

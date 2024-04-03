package com.example.verbindung;
import com.example.verbindung.model.Message;
import com.example.verbindung.repository.MessageRepository;
import com.example.verbindung.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageService messageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldPostMessage() {
        Message message = new Message();
        message.setContent("Hello World");

        when(messageRepository.save(any(Message.class))).thenReturn(message);

        Message savedMessage = messageService.postMessage(message);

        verify(messageRepository, times(1)).save(any(Message.class));
        assertEquals("Hello World", savedMessage.getContent());
    }

    @Test
    void shouldFindMessagesByUserId() {
        Message message = new Message();
        message.setContent("Test Message");

        when(messageRepository.findByUserId(anyLong())).thenReturn(Collections.singletonList(message));

        List<Message> messages = messageService.findMessagesByUserId(1L);

        assertEquals(1, messages.size());
        assertEquals("Test Message", messages.get(0).getContent());
    }
}
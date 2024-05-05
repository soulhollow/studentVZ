package com.example.verbindung;


import com.example.verbindung.model.Message;

import java.time.LocalDateTime;

public class TOMessage {
    private Long id;
    private String header;
    private String content;
    private LocalDateTime timestamp;
    private String email;

    public TOMessage(Message message) {
        this.id = message.getId();
        this.header = message.getHeader();
        this.content = message.getContent();
        this.timestamp = message.getTimestamp();
        this.email = message.getUser().getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

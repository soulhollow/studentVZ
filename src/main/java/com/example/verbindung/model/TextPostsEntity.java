package com.example.verbindung.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "textposts", schema = "StudentVZ") //ändern auf unser werte
public class TextPostsEntity {

    @Id
    @Column(name ="idTextPosts", nullable = false)
    private int postId;

    @Column(name = "idUserAccounts", nullable = false)
    private int profileId;

    @Column(name = "contentTextPost")
    private String contentTextPost;

}

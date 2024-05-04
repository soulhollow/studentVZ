package com.example.verbindung;

import com.example.verbindung.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class UserContext {
    private static User loggedInUser;

    public UserContext() {    }

    public UserContext userContext(){
        return new UserContext();
    }
    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        UserContext.loggedInUser = loggedInUser;
    }
}

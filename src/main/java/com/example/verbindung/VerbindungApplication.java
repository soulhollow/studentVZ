package com.example.verbindung;

import com.example.verbindung.model.Message;
import com.example.verbindung.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VerbindungApplication {

	public static void main(String[] args) {
		SpringApplication.run(VerbindungApplication.class, args);
		User user = new User("name","password","test");
		System.out.println(user.getEmail());
	}

}

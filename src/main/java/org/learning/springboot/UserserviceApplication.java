package org.learning.springboot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.learning.springboot.repositories.UserRepository;
import org.learning.springboot.schema.Address;
import org.learning.springboot.schema.Company;
import org.learning.springboot.schema.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.util.List;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return (evt) -> {
            ObjectMapper objectMapper = new ObjectMapper();
            List<User> users = objectMapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream("user-data.json"), new TypeReference<List<User>>() {});

            userRepository.save(users);
        };
    }
}

package com.example.demo;

import com.example.demo.model.AppUser;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication  {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    PasswordEncoder passwordEncoder;

//    @Override
//    public void run(String... args) throws Exception {
//
//        AppUser user = new AppUser();
//        user.setUsername("van");
//        user.setPassword(passwordEncoder.encode("van"));
//        userRepository.save(user);
//        System.out.println(user);
//    }
}

package com.elkabani.userregistration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class UserRegistrationApplicationTests {

    @Test
    void contextLoads() {
        ApplicationContext context = SpringApplication.run(UserRegistrationApplication.class, "");
        var userService = context.getBean(UserService.class);

        userService.registerUser(new User(4L, "John Jane",  "jj1234@example.com", "password012"));
        userService.sendNotification();
        userService.registerUser(new User(5L, "Doe John",  "djohn@example.com", "password345"));
        userService.sendNotification();
        userService.registerUser(new User(5L, "Doe John",  "djohn@example.com", "password345"));
    }

}

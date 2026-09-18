package com.elkabani.userregistration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("email")
@Primary
public class EmailNotificationService  implements NotificationService {

    @Value("${email.host}")
    private String host;
    @Value("${email.port}")
    private String port;

    @Override
    public void send(String message, String recipientEmail) {
        // Simulate sending an email
        System.out.println("Recipient: " + recipientEmail);
        System.out.println("Email Notification: " + message + recipientEmail);
        System.out.println("Email Host: " + host);
        System.out.println("Email Port: " + port);
    }
}
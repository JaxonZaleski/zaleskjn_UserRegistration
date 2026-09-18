package com.elkabani.userregistration;

import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService {
    //region Variables
    private User User = new User();
    private EmailNotificationService notificationSend = new EmailNotificationService();
    private UserRepository userRepo = new UserRepository() {
        @Override
        public void save(User user) {
            User.setId(user.getId());
            User.setName(user.getName());
            User.setEmail(user.getEmail());
            User.setPassword(user.getPassword());
        }

        @Override
        public User findByEmail(String email) {
            return null;
        }
    };
    private long[] userId = new long[1000];
    private int idIndex = 0;
    //endregion

    public void registerUser(User user) {
        for(int i = 0; i <= userId.length-1; i++) {
            if(userId[i] == user.getId()) {
                System.out.println("There is already a user with an identical ID! ID: " + User.getId());
                return;
            }
        }

        userRepo.save(user);
        userId[idIndex] += user.getId();
        idIndex++;

        System.out.println("ID: " + User.getId());
    }

    public void sendNotification() {
        notificationSend.send("This user has been created with this email: ", User.getEmail());
    }
}
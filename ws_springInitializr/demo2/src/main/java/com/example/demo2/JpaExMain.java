package com.example.demo2;

import com.example.demo2.entity.User;
import com.example.demo2.service.UserService;

public class JpaExMain {
    public static void main(String[] args) {

        UserService userService = new UserService();;

        //userService.createUser("Alice", "alice@green.com", 30);
        //userService.createUser("Bob", "bob@green.com", 30);
        //userService.createUser("Charlie", "charlie@green.com", 30);

        //User user = userService.findUserById(10L);
        userService.findAllUsers();

        //userService.updateUser(1L, "alice-update@green.com");
    }
}

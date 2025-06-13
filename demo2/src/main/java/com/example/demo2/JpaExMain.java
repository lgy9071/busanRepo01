package com.example.demo2;

import com.example.demo2.entity.User;
import com.example.demo2.service.UserService;

import java.util.List;

public class JpaExMain {
    public static void main(String[] args) {
        UserService userService = new UserService();;

        //사용자 생성
        //userService.createUser("Alice", "alice@green.com", 30);
        //userService.createUser("Bob", "bob@green.com", 30);
        //userService.createUser("Charlie", "charlie@green.com", 30);

        //사용자 id로 찾기
        //User user = userService.findUserById(10L);
        //userService.findAllUsers();

        //사용자 메일 업데이트
        //userService.updateUser(1L, "alice-update@green.com");

        //특정 사용자 정보로 조회
       //List<User> list =  userService.findUsersByAge(26);
       //for(User user : list){
       //    System.out.println(user.getUserName() + "," + user.getAge());
       //}

        //3번 사용자 정보 삭제
        //userService.deleteUser(3L);

        userService.mergeUser();

    }
}

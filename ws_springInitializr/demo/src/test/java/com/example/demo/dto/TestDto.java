package com.example.demo.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDto {

    @Test
    void testUserDto(){
        UserDto user = new UserDto();
        user.setUsername("hong");
        user.setName("홍길동");
        user.setPassword("1234");

        assertEquals("홍길동", user.getName());
    }
}

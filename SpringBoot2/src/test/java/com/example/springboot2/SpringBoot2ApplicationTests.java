package com.example.springboot2;

import com.example.springboot2.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringBoot2ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void processRegister() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPass = encoder.encode("ba");

        System.out.println(encodedPass);
    }
}

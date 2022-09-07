package com.example.springboot2;

import com.example.springboot2.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class SpringBoot2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2Application.class, args);
    }

}

package com.cosmos.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cosmos.demo.listener.MyApplicationStartedEventListener;
import com.cosmos.demo.listener.MyApplicationEnvironmentPreparedEventListener;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.addListeners(new MyApplicationStartedEventListener(),
                         new MyApplicationEnvironmentPreparedEventListener());
        app.run(args);
    }
}

package ru.mike.serviceA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.mike.serviceA.service.MessageGenerateService;
import ru.mike.serviceA.service.OrderMessageSender;

@SpringBootApplication
public class ServiceApplication implements CommandLineRunner {
    @Autowired
    OrderMessageSender orderMessageSender;

    @Autowired
    MessageGenerateService messageGenerateService;

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        for (int i = 0; i < 10; i++) {
            orderMessageSender.sendOrder(messageGenerateService.generateMessage());
        }
    }
}

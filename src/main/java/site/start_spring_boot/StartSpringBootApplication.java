package site.start_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StartSpringBootApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StartSpringBootApplication.class, args);

        Client client = context.getBean(Client.class);
        client.processMessage("Hello, Spring Boot!");

    }

}

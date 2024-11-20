package site.start_spring_boot;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageService {

    // Khi đánh dấu @Component, Spring Boot sẽ tự động quản lý đối tượng EmailService này
    @Override
    public void sendMessage(String message) {
        System.out.println("Email message: " + message);
    }
}

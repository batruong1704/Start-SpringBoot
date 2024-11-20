package site.start_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Client {
    @Autowired
    private MessageService messageService;

    public Client(MessageService messageService) {
        this.messageService = messageService;
    }

    public void processMessage(String message) {
        this.messageService.sendMessage(message);
    }
}

package creational_pattern.factory_method_pattern.controller;

import creational_pattern.factory_method_pattern.service.NotificationService;
import creational_pattern.factory_method_pattern.type.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public String send(@RequestParam NotificationType type,
                       @RequestParam String to,
                       @RequestParam String message) {
        notificationService.notifyUser(type, to, message);
        return "Notification sent!";
    }
}

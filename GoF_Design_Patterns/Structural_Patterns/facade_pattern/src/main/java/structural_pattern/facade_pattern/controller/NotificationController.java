package structural_pattern.facade_pattern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import structural_pattern.facade_pattern.facade.NotificationFacade;
import structural_pattern.facade_pattern.model.NotificationRequest;

@RestController
@RequestMapping("/api/v1/notify")
public class NotificationController {

    @Autowired
    private NotificationFacade notify;

    @PostMapping("/all")
    public String sendToAll(@RequestBody NotificationRequest request) {
        notify.sendAll(request.getEmail(), request.getPhone(), request.getDeviceId(), request.getMessage());
        return "Sent to all channels";
    }

    @PostMapping("/email")
    public String sendToEmail(@RequestBody NotificationRequest request) {
        notify.sendEmailOnly(request.getEmail(), request.getMessage());
        return "Email sent";
    }

    @PostMapping("/sms")
    public String sendSms(@RequestBody NotificationRequest request) {
        notify.sendSmsOnly(request.getPhone(), request.getMessage());
        return "Sms sent";
    }

    @PostMapping("/push-notify")
    public String sendPushNotify(@RequestBody NotificationRequest request) {
        notify.sendPushOnly(request.getDeviceId(), request.getMessage());
        return "Push notify sent";
    }
}

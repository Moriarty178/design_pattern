package structural_pattern.facade_pattern.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import structural_pattern.facade_pattern.service.EmailService;
import structural_pattern.facade_pattern.service.PushNotification;
import structural_pattern.facade_pattern.service.SmsService;

@Component
public class NotificationFacade {

    @Autowired
    private EmailService emailService;

    @Autowired
    private SmsService smsService;

    @Autowired
    private PushNotification pushNotification;

    public void sendAll(String email, String phone, String deviceId, String message) {
        emailService.sendEmail(email, message);
        smsService.sendSms(phone, message);
        pushNotification.sendPush(deviceId, message);
    }

    public void sendEmailOnly(String email, String message) {
        emailService.sendEmail(email, message);
    }

    public void sendSmsOnly(String phone, String message) {
        smsService.sendSms(phone, message);
    }

    public void sendPushOnly(String deviceId, String message) {
        pushNotification.sendPush(deviceId, message);
    }


}

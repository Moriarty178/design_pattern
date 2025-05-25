package structural_pattern.facade_pattern.service;

import org.springframework.stereotype.Service;

@Service
public class SmsService {
    public void sendSms(String phone, String message) {
        System.out.println("SMS send to " + phone +  ": " + message);
    }
}

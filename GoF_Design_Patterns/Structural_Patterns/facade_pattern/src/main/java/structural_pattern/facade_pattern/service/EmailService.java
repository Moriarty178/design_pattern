package structural_pattern.facade_pattern.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void sendEmail(String to, String message) {
        System.out.println("Email send to " + to + ": " + message);
    }
}

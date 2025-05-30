package behavioral_patterns.command_pattern.receiver;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void sendEmail(String to, String subject, String content) {
        System.out.println("Sending email to: " + to + " ,with subject: '" + subject + "'");
    }
}

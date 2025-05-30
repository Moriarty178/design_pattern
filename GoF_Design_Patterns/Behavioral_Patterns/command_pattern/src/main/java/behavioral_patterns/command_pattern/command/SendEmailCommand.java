package behavioral_patterns.command_pattern.command;

import behavioral_patterns.command_pattern.receiver.EmailService;

import java.util.Random;

public class SendEmailCommand implements TaskCommand{
    private final EmailService emailService;

    private final int emailCommandNumber = (int) (Math.random() * 100);

    public SendEmailCommand(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void execute() {
        emailService.sendEmail(emailCommandNumber + "hermione@gmail.com", "Welcome!", "Thank you for registering.");
    }

    @Override
    public void undo() {
        System.out.println("Undo send email to Hermione." + emailCommandNumber);
    }
}

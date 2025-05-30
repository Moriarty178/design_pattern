package behavioral_patterns.command_pattern.controller;

import behavioral_patterns.command_pattern.command.PrintReportCommand;
import behavioral_patterns.command_pattern.command.SendEmailCommand;
import behavioral_patterns.command_pattern.invoker.TaskExecutorService;
import behavioral_patterns.command_pattern.receiver.EmailService;
import behavioral_patterns.command_pattern.receiver.ReportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskExecutorService executorService;
    private final EmailService emailService;
    private final ReportService reportService;

    public TaskController(TaskExecutorService executorService, EmailService emailService, ReportService reportService) {
        this.executorService = executorService;
        this.emailService = emailService;
        this.reportService = reportService;
    }

    @PostMapping("/email")
    public String sendEmailTask() {
        executorService.addTask(new SendEmailCommand(emailService));
        return "Email task added";
    }

    @PostMapping("/report")
    public String printReportTask() {
        executorService.addTask(new PrintReportCommand(reportService));
        return "Report task added";
    }

    @PostMapping("/run")
    public String executeAllTasks() {
        executorService.runAll();
        return "All tasks executed";
    }

    @PostMapping("/undo")
    public String undo() {
        executorService.undo();
        return "Undo done";
    }

    @PostMapping("/redo")
    public String redo() {
        executorService.redo();
        return "Redo done";
    }
}

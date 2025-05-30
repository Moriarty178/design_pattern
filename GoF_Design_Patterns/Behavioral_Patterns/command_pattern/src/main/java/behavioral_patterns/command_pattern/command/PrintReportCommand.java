package behavioral_patterns.command_pattern.command;

import behavioral_patterns.command_pattern.receiver.ReportService;

import java.util.Random;

public class PrintReportCommand implements TaskCommand{
    private final ReportService reportService;

    private final int reportCommandNumber = (int) (Math.random() * 100);

    public PrintReportCommand(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public void execute() {
        reportService.printReport("Monthly Sales" + reportCommandNumber);
    }

    @Override
    public void undo() {
        System.out.println("Undo print report." + reportCommandNumber);
    }
}

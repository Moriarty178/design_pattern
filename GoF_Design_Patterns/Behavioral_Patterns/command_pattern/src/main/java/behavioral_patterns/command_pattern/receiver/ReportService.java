package behavioral_patterns.command_pattern.receiver;

import org.springframework.stereotype.Service;

@Service
public class ReportService {
    public void printReport(String reportName) {
        System.out.println("Printing report: " + reportName);
    }
}

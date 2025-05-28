package behavioral_patterns.template_method_pattern;

public class SalesReportGenerator extends ReportGenerator{

    @Override
    protected void formatData() {
        System.out.println("Formatting sales data...");
    }

    @Override
    protected void beforeExport() {
        System.out.println("Applying watermark: 'Confidential'");
    }

//    @Override
//    protected void exportData() {
//        super.exportData();
//    }
}

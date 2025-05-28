package behavioral_patterns.template_method_pattern;

public class InventoryReportGenerator extends ReportGenerator{
    @Override
    protected void formatData() {
        System.out.println("Formatting inventory data...");
    }

//    @Override
//    protected void beforeExport() {
//        super.beforeExport();
//    }
//
//    @Override
//    protected void exportData() {
//        super.exportData();
//    }
}

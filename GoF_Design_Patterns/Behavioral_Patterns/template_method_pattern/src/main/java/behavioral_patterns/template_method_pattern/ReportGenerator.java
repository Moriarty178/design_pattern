package behavioral_patterns.template_method_pattern;

public abstract class ReportGenerator {

    // Template Method: không cho override - đảm bảo toàn bộ ai sử dụng generateReport phải tuân theo quy trình này
    public final void generateReport() {
        fetchDate();
        formatData();
        beforeExport();
        exportData();
    }

    protected final void fetchDate() { // đã cài đặt, class con phải tuân theo
        System.out.println("Fetching Data from DB...");
    }

    // bắt buộc class con phải triển khai
    protected abstract void formatData();

    // Hook method: có thể override hoặc không
    protected void beforeExport() {
        // do nothing
    }

    protected void exportData() { // class con có thể overrdie nếu cân
        System.out.println("Exporting to PDF...");
    }
}

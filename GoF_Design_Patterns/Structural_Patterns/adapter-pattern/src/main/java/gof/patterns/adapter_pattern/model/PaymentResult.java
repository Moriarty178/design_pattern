package gof.patterns.adapter_pattern.model;

public class PaymentResult {
    private boolean success; // status
    private String transactionCode;// = "txn_"+ userId
    private String description; // = message
    private String totalDisplay; // = amount + currency

    public PaymentResult(boolean success, String transactionCode, String description, String totalDisplay) {
        this.success = success;
        this.transactionCode = transactionCode;
        this.description = description;
        this.totalDisplay = totalDisplay;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTotalDisplay() {
        return totalDisplay;
    }

    public void setTotalDisplay(String totalDisplay) {
        this.totalDisplay = totalDisplay;
    }

//    @Override
//    public String toString() {
//        return "success: " + success + " transactionCode: " + transactionCode
//                + " description: " + description + " totalDisplay: " + totalDisplay;
//    }
}

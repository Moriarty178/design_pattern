package gof.patterns.adapter_pattern.model;

public class PaymentRequest { // input của chuẩn mới
    private String userId;
    private double amount;
    private String currency;

    public PaymentRequest(String userId, double amount, String currency) {
        this.userId = userId;
        this.amount = amount;
        this.currency = currency;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

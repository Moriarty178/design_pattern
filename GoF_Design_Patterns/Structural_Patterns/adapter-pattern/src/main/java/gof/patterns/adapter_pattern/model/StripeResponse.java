package gof.patterns.adapter_pattern.model;

public class StripeResponse { // old response
    private String userId;
    private double amount;
    private String currency;
    private String status = "SUCCESS";
    private String message = "MESS";

    public StripeResponse(String userId, double amount, String currency, String status, String message) {
        this.userId = userId;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.message = message;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

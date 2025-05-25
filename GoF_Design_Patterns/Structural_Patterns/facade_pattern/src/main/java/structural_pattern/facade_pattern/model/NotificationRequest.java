package structural_pattern.facade_pattern.model;

public class NotificationRequest {
    private String email;
    private String phone;
    private String deviceId;
    private String message;

    public NotificationRequest() {
    }

    public NotificationRequest(String email, String phone, String deviceId, String message) {
        this.email = email;
        this.phone = phone;
        this.deviceId = deviceId;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

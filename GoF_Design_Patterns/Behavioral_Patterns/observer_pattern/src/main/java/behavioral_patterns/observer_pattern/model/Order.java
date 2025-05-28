package behavioral_patterns.observer_pattern.model;

public class Order {
    private String id;
    private String customerEmail;
    private String address;

    public Order(String id, String customerEmail, String address) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getAddress() {
        return address;
    }
}

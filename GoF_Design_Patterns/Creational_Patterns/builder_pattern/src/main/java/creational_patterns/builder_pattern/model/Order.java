package creational_patterns.builder_pattern.model;

import java.util.List;

public class Order {
    private String customerName;
    private List<Product> products;
    private String shippingAddress;
    private String paymentMethod;
    private String note;
    private String discountCode;

    private Order(Builder builder) {
        this.customerName = builder.customerName;
        this.products = builder.products;
        this.shippingAddress = builder.shippingAddress;
        this.paymentMethod = builder.paymentMethod;
        this.note = builder.note;
        this.discountCode = builder.discountCode;
    }

    public static class Builder {
        private String customerName;
        private List<Product> products;
        private String shippingAddress;
        private String paymentMethod;
        private String note;
        private String discountCode;

        public Builder(String customerName, List<Product> products) { // constructor khởi tạo
            this.customerName = customerName;
            this.products = products;
        }

        public Builder shippingAddress(String shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        public Builder paymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder note(String note) {
            this.note = note;
            return this;
        }

        public Builder discountCode(String discountCode) {
            this.discountCode = discountCode;
            return this;
        }

        public Order build() { // khá giống terminate của stream
            return new Order(this);
        }
    }

    @Override
    public String toString() {
        return "Order by "  + customerName + ", Products: " + products.size()
                + ", Payment: " + paymentMethod + ", Note: " + note;
    }
}

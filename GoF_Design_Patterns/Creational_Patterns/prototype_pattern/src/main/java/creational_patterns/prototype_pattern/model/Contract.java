package creational_patterns.prototype_pattern.model;

import java.util.Date;

public class Contract implements  Cloneable {
    private String customerName;
    private String content;
    private Date createdDate;

    public Contract(String customerName, String content, Date createdDate) {
        this.customerName = customerName;
        this.content = content;
        this.createdDate = createdDate;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public Contract clone() {
        try {
            Contract clone = (Contract) super.clone();
            clone.setCreatedDate((Date) this.createdDate.clone()); // deep clone
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone failed", e);
        }
    }

    public void print() {
        System.out.println("Contract for: " + customerName);
        System.out.println("Content: " + content);
        System.out.println("Created on: " + createdDate);
        System.out.println("-------------------------------");
    }
}

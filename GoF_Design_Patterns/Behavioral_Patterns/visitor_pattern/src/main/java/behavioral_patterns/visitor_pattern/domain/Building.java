package behavioral_patterns.visitor_pattern.domain;

import behavioral_patterns.visitor_pattern.visitor.AssetVisitor;

public class Building implements Asset{
    private String address;
    private double area;

    public Building(String address, double area) {
        this.address = address;
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public double getArea() {
        return area;
    }

    @Override
    public void accept(AssetVisitor visitor) {
        visitor.visit(this);
    }
}

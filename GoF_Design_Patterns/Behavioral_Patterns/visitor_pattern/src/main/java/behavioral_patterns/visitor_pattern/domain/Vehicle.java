package behavioral_patterns.visitor_pattern.domain;

import behavioral_patterns.visitor_pattern.visitor.AssetVisitor;

public class Vehicle implements Asset{
    private String model;
    private int year;

    public Vehicle(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public void accept(AssetVisitor visitor) {
        visitor.visit(this);
    }
}

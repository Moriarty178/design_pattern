package behavioral_patterns.visitor_pattern.domain;

import behavioral_patterns.visitor_pattern.visitor.AssetVisitor;

public class Computer implements Asset {
    private String serial;
    private String os;

    public Computer(String serial, String os) {
        this.serial = serial;
        this.os = os;
    }

    public String getSerial() {
        return serial;
    }

    public String getOs() {
        return os;
    }

    @Override
    public void accept(AssetVisitor visitor) {
        visitor.visit(this);
    }
}

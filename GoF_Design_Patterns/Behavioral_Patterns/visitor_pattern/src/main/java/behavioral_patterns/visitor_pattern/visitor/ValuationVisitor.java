package behavioral_patterns.visitor_pattern.visitor;

import behavioral_patterns.visitor_pattern.domain.Building;
import behavioral_patterns.visitor_pattern.domain.Computer;
import behavioral_patterns.visitor_pattern.domain.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class ValuationVisitor implements AssetVisitor { // hành vi "Định giá tài sản"

    @Override
    public void visit(Vehicle vehicle) {
        System.out.println("Valuating vehicle: " + vehicle.getModel() + " - Estimated: $" + (2025 - vehicle.getYear()) * 1000);
    }

    @Override
    public void visit(Building building) {
        System.out.println("Valuating building: " + building.getAddress() + " - Estimated: $" + building.getArea() * 2000);
    }

    @Override
    public void visit(Computer computer) {
        System.out.println("Valuating computer: " + computer.getSerial() + " - Estimated: $" + (computer.getOs().equalsIgnoreCase("Linux") ? 500 : 800));
    }
}

package behavioral_patterns.visitor_pattern.visitor;

import behavioral_patterns.visitor_pattern.domain.Building;
import behavioral_patterns.visitor_pattern.domain.Computer;
import behavioral_patterns.visitor_pattern.domain.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class ExportVisitor implements AssetVisitor { // hành vi "Export báo cáo"
    @Override
    public void visit(Vehicle vehicle) {
        String json = String.format("{ \"type\": \"Vehicle\", \"model\": \"%s\", \"year\": %d }",
                vehicle.getModel(), vehicle.getYear());
        System.out.println(json);
    }

    @Override
    public void visit(Building building) {
        String json = String.format("{ \"type\": \"Building\", \"address\": \"%s\", \"area\": %.2f }",
                building.getAddress(), building.getArea());
        System.out.println(json);
    }

    @Override
    public void visit(Computer computer) {
        String json = String.format("{ \"type\": \"Computer\", \"serial\": \"%s\", \"os\": \"%s\" }",
                computer.getSerial(), computer.getOs());
        System.out.println(json);
    }

}

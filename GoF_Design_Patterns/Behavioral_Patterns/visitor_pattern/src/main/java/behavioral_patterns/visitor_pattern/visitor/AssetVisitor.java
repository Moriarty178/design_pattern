package behavioral_patterns.visitor_pattern.visitor;

import behavioral_patterns.visitor_pattern.domain.Building;
import behavioral_patterns.visitor_pattern.domain.Computer;
import behavioral_patterns.visitor_pattern.domain.Vehicle;

public interface AssetVisitor {
    void visit(Vehicle vehicle);
    void visit(Building building);
    void visit(Computer computer);
}

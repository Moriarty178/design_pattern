package behavioral_patterns.visitor_pattern.visitor;

import behavioral_patterns.visitor_pattern.domain.Building;
import behavioral_patterns.visitor_pattern.domain.Computer;
import behavioral_patterns.visitor_pattern.domain.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class AuditVisitor implements AssetVisitor { // Hành vi "Kiểm toán tài sản": bây giờ khi ta thêm 1 hành vi mới ta chỉ cần tạo class mới impl interface Visitor -> các class gốc (computer, vehicle, building) do đang ủy quyển "sử dụng" visitor cho việc thực hiện hành vi NÊN => nó cũng sẽ có luôn cả hành vi mới - hành vi mới là class implement interface Visitor"
    @Override
    public void visit(Vehicle vehicle) {
        System.out.println("Auditing vehicle: " + vehicle.getModel() + " (" + vehicle.getYear() + ")");
    }

    @Override
    public void visit(Building building) {
        System.out.println("Auditing building at: " + building.getAddress() + " with area " + building.getArea());
    }

    @Override
    public void visit(Computer computer) {
        System.out.println("Auditing computer with serial: " + computer.getSerial() + " and OS " + computer.getOs());
    }
}

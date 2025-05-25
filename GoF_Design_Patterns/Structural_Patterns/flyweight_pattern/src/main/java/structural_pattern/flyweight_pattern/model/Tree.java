package structural_pattern.flyweight_pattern.model;

import structural_pattern.flyweight_pattern.flyweight.TreeType;

public class Tree {
    private final int x;
    private final int y;
    private final TreeType type; // tham chiếu đến treeType thay vì tạo độc lập các thuộc tính trùng lặp cho mỗi tree (tốn ram)

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TreeType getType() {
        return type;
    }
}

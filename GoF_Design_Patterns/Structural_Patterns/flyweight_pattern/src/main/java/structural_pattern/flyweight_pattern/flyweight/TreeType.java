package structural_pattern.flyweight_pattern.flyweight;

public class TreeType { // flyweight
    private final String name;
    private final String color;
    private final String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) {
        System.out.printf("Draw %s tree at (%d, %d) with color %s and textur %s%n",
                name, x, y, color, texture);
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getTexture() {
        return texture;
    }
}

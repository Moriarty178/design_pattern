package structural_pattern.composite_pattern.leaf;

import structural_pattern.composite_pattern.component.MenuComponent;

public class MenuItem extends MenuComponent {
    private final String name;

    public MenuItem(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print(String prefix) {
//        System.out.println("Item: " + getName());
        System.out.println(prefix + "📄 " + name);
    }
}

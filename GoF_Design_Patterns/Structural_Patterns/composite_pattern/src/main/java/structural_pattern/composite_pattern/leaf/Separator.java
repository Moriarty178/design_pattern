package structural_pattern.composite_pattern.leaf;

import structural_pattern.composite_pattern.component.MenuComponent;

public class Separator extends MenuComponent {
    private final String name;

    public Separator(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix + "🍔 " + getName());
    }
}

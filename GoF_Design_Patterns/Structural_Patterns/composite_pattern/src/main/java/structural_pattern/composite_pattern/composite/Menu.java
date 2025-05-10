package structural_pattern.composite_pattern.composite;

import structural_pattern.composite_pattern.component.MenuComponent;

import java.util.ArrayList;
import java.util.List;

public class Menu extends MenuComponent {
    private final String name;
    private final List<MenuComponent> children = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    @Override
    public void add(MenuComponent component) {
        children.add(component);
    }

    @Override
    public void remove(MenuComponent component) {
        children.remove(component);
    }

    @Override
    public MenuComponent getChild(int index) {
        return children.get(index);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print(String prefix) {
//        System.out.println("Menu: " + getName());
        System.out.println(prefix + "📂 " + name);
        for (MenuComponent component : children) {
            component.print(prefix + "    "); //1 trong ý nghĩa composite_pattern cho phép ta chạy một hành vi đệ quy trên toàn bô thành phần của cây đối tượng.
        }
    }
}

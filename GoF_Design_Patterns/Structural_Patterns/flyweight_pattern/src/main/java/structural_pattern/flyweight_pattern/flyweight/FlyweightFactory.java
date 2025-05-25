package structural_pattern.flyweight_pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory { // quan ly 1 nhom cac flyweight
    public static final Map<String, TreeType> types = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "-" + color + "-" + texture;
        if (!types.containsKey(key)) {
            types.put(key, new TreeType(name, color, texture));
            System.out.println("Created new TreeType: " + key);
        }
        return types.get(key);
    }

    public static int getTotalTreeType() {
        return types.size();
    }
}

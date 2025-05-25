package structural_pattern.flyweight_pattern.service;

import org.springframework.stereotype.Service;
import structural_pattern.flyweight_pattern.flyweight.FlyweightFactory;
import structural_pattern.flyweight_pattern.model.Tree;
import structural_pattern.flyweight_pattern.flyweight.TreeType;

import java.util.*;

@Service
public class ForestService {
    private final List<Tree> trees = new ArrayList<>();
    private final Random rand = new Random();

    public void plantRandomTrees(int count) {
        String[] names = {"Harry", "Hermione", "John"};
        String[] colors = {"Green", "Red", "Blue"};
        String[] textures = {"Rough", "Smooth"};

        for (int i = 0; i < count; i++) {
            String name = names[rand.nextInt(names.length)];
            String color = colors[rand.nextInt(colors.length)];
            String texture = textures[rand.nextInt(textures.length)];

            TreeType type = FlyweightFactory.getTreeType(name, color, texture);
            Tree tree = new Tree(rand.nextInt(1000), rand.nextInt(1000), type);
            trees.add(tree);
        }
    }

    public void drawForest() {
        for (Tree tree : trees) {
            tree.draw();
        }
        System.out.printf("Total trees: %d, Tree types: %d%n", trees.size(), FlyweightFactory.getTotalTreeType());
    }

}

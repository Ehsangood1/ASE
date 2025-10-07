package com.github.ASE.Flyweight;

import java.util.ArrayList;
import java.util.List;

import com.github.ASE.Flyweight.Extrinsics.Tree;
import com.github.ASE.Flyweight.Intrinsics.TreeType;
import com.github.ASE.Flyweight.Intrinsics.TreeTypeFactory;

public class App {
    private final List<Tree> forest = new ArrayList<>();

    public void plantTree(int x, int y, String type, String color, String texture, int height) {
        TreeType treeType = TreeTypeFactory.getTreeType(type, color, texture);
        Tree tree = new Tree(x, y, height, treeType);
        forest.add(tree);
    }

    public void render() {
        System.out.println("Rendering Forest...");
        for (Tree tree : forest) {
            tree.render();
        }
    }

    public static void main(String[] args) {
        App forestSimulator = new App();

        // Plant 1000 trees with only 3 unique types
        for (int i = 0; i < 333; i++) {
            forestSimulator.plantTree(i * 2, i * 1, "Oak", "Green", "Bark1", 10);
        }
        for (int i = 333; i < 666; i++) {
            forestSimulator.plantTree(i * 2, i * 1, "Pine", "Green", "Bark2", 15);
        }
        for (int i = 666; i < 1000; i++) {
            forestSimulator.plantTree(i * 2, i * 1, "Birch", "White", "Smooth", 12);
        }

        // Render the forest
        forestSimulator.render();

        // Show memory efficiency
        System.out.println("\nTotal Tree Types (Flyweight Count): " + TreeTypeFactory.getTreeTypeCount());
        System.out.println("Total Trees Created: " + forestSimulator.forest.size());
    }
}

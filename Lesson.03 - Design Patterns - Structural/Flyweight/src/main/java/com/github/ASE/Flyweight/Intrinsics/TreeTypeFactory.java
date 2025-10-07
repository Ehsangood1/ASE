package com.github.ASE.Flyweight.Intrinsics;

import java.util.HashMap;
import java.util.Map;

public class TreeTypeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String type, String color, String texture) {
        String key = type + color + texture;
        if (!treeTypes.containsKey(key)) {
            treeTypes.put(key, new TreeType(type, color, texture));
        }
        return treeTypes.get(key);
    }

    public static int getTreeTypeCount() {
        return treeTypes.size();
    }
}

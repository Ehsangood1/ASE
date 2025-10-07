package com.github.ASE.Flyweight.Intrinsics;

public class TreeType {
    private final String type;
    private final String color;
    private final String texture;

    public TreeType(String type, String color, String texture) {
        this.type = type;
        this.color = color;
        this.texture = texture;
    }

    public void render(int x, int y, int height) {
        System.out.println("Rendering " + type + " tree at (" + x + ", " + y + ") - " + height + "m - " + color + " ("
                + texture + ")");
    }
}

package com.github.ASE.Flyweight.Extrinsics;

import com.github.ASE.Flyweight.Intrinsics.TreeType;

public class Tree {
    private final int x;
    private final int y;
    private final int height;
    private final TreeType treeType;

    public Tree(int x, int y, int height, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.treeType = treeType;
    }

    public void render() {
        treeType.render(x, y, height);
    }
}

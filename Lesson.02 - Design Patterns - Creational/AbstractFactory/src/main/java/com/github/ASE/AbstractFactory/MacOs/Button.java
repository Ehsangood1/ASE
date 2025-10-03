package com.github.ASE.AbstractFactory.MacOs;

import com.github.ASE.AbstractFactory.UIComponent;

import javafx.scene.Node;

public class Button implements UIComponent {
    final private javafx.scene.control.Button button;

    public Button() {
        this.button = new javafx.scene.control.Button("MacOs Button");
    }

    @Override
    public Node render() {
        return this.button;
    }
}

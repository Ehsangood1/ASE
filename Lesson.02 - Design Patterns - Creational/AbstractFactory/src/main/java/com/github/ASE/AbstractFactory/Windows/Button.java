package com.github.ASE.AbstractFactory.Windows;

import com.github.ASE.AbstractFactory.UIComponent;

import javafx.scene.Node;

public class Button implements UIComponent {
    final private javafx.scene.control.Button button;

    public Button() {
        this.button = new javafx.scene.control.Button("Windows Button");
    }

    @Override
    public Node render() {
        return this.button;
    }
}

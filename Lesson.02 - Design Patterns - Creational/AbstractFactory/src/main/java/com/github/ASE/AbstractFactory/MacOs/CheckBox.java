package com.github.ASE.AbstractFactory.MacOs;

import com.github.ASE.AbstractFactory.UIComponent;

import javafx.scene.Node;

public class CheckBox implements UIComponent {
    final private javafx.scene.control.CheckBox checkBox;

    public CheckBox() {
        this.checkBox = new javafx.scene.control.CheckBox("MacOs CheckBox");
    }

    @Override
    public Node render() {
        return this.checkBox;
    }
}

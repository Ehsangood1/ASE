package com.github.ASE.AbstractFactory.MacOs;

import com.github.ASE.AbstractFactory.UIComponent;
import com.github.ASE.AbstractFactory.UIComponentFactory;

public class Factory implements UIComponentFactory {

    @Override
    public UIComponent createButton() {
        return new Button();
    }

    @Override
    public UIComponent createCheckBox() {
        return new CheckBox();
    }

}

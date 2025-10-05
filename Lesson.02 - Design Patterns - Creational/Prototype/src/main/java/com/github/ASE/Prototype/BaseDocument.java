package com.github.ASE.Prototype;

public abstract class BaseDocument implements Document {
    private String content;

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    protected String getContent() {
        return this.content;
    }

    @Override
    public abstract Document clone();
}

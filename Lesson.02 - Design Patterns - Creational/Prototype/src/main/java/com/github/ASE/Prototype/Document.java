package com.github.ASE.Prototype;

import java.io.PrintStream;

public interface Document extends Cloneable {
    void setContent(String content);

    void render(PrintStream ps);

    Document clone();
}

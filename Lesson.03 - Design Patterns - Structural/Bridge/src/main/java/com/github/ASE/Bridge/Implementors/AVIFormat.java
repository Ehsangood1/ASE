package com.github.ASE.Bridge.Implementors;

public class AVIFormat implements MediaFormat {

    @Override
    public void play(String filename) {
        System.out.println("Playing AVI file: " + filename);
    }
}

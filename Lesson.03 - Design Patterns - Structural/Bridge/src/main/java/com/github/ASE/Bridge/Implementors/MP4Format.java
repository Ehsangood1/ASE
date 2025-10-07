package com.github.ASE.Bridge.Implementors;

public class MP4Format implements MediaFormat {

    @Override
    public void play(String filename) {
        System.out.println("Playing MP4 file: " + filename);
    }
}

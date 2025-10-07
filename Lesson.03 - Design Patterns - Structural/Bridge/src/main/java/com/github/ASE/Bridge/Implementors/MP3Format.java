package com.github.ASE.Bridge.Implementors;

public class MP3Format implements MediaFormat {

    @Override
    public void play(String filename) {
        System.out.println("Playing MP3 file: " + filename);
    }
}

package com.github.ASE.Bridge.Abstractions;

import com.github.ASE.Bridge.Implementors.MediaFormat;

public class AudioPlayer extends MediaPlayer {

    public AudioPlayer(MediaFormat mediaFormat) {
        super(mediaFormat);
    }

    @Override
    public void playMedia(String filename) {
        System.out.println("AudioPlayer: Playing audio file...");
        mediaFormat.play(filename);
    }
}

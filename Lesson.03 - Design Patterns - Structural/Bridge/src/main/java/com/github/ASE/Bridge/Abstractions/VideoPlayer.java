package com.github.ASE.Bridge.Abstractions;

import com.github.ASE.Bridge.Implementors.MediaFormat;

public class VideoPlayer extends MediaPlayer {
    public VideoPlayer(MediaFormat mediaFormat) {
        super(mediaFormat);
    }

    @Override
    public void playMedia(String filename) {
        System.out.println("VideoPlayer: Playing video file with advanced features...");
        enableSubtitles();
        adjustVolume();
        mediaFormat.play(filename);
    }

    private void enableSubtitles() {
        System.out.println("Subtitles enabled.");
    }

    private void adjustVolume() {
        System.out.println("Volume set to 75%.");
    }
}

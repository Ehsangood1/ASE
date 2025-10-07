package com.github.ASE.Bridge.Abstractions;

import com.github.ASE.Bridge.Implementors.MediaFormat;

public abstract class MediaPlayer {
    protected MediaFormat mediaFormat;

    protected MediaPlayer(MediaFormat mediaFormat) {
        this.mediaFormat = mediaFormat;
    }

    public abstract void playMedia(String filename);
}

package com.github.ASE.Bridge;

import com.github.ASE.Bridge.Abstractions.AudioPlayer;
import com.github.ASE.Bridge.Abstractions.MediaPlayer;
import com.github.ASE.Bridge.Abstractions.VideoPlayer;
import com.github.ASE.Bridge.Implementors.AVIFormat;
import com.github.ASE.Bridge.Implementors.MP3Format;
import com.github.ASE.Bridge.Implementors.MP4Format;
import com.github.ASE.Bridge.Implementors.MediaFormat;

public class App {

    public static void main(String[] args) {
        MediaFormat mp3Format = new MP3Format();
        MediaPlayer windowsAudioPlayer = new AudioPlayer(mp3Format);
        windowsAudioPlayer.playMedia("song.mp3");
        System.out.println();

        MediaFormat mp4Format = new MP4Format();
        MediaPlayer macVideoPlayer = new VideoPlayer(mp4Format);
        macVideoPlayer.playMedia("movie.mp4");
        System.out.println();

        MediaFormat aviFormat = new AVIFormat();
        MediaPlayer windowsVideoPlayer = new VideoPlayer(aviFormat);
        windowsVideoPlayer.playMedia("video.avi");
    }

}

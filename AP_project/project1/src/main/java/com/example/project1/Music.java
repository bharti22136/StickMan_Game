package com.example.project1;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.*;
import java.util.concurrent.CompletableFuture;

public class Music {
    private MediaPlayer backgroundPlayer;
    public void backgroundConstant() {
        try {
            // Load the music file
            Media media = new Media(getClass().getResource("BackMusic.mp3").toString());

            // Create a MediaPlayer
            backgroundPlayer = new MediaPlayer(media);

            // Set to loop indefinitely
            backgroundPlayer.setCycleCount(MediaPlayer.INDEFINITE);

            // Play the music
            backgroundPlayer.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    Media media1 = new Media(getClass().getResource("thump.mp3").toString());
    MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
    public void stickIncreaseSound() {
        try {

            mediaPlayer1.setCycleCount(1);
            // Release resources after the sound has finished playing
            mediaPlayer1.setOnEndOfMedia(() -> {
                mediaPlayer1.dispose();
            });
            // Play the music
            mediaPlayer1.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void stickIncreaseSoundStop() {
        if (mediaPlayer1 != null && mediaPlayer1.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer1.setCycleCount(0);
        }
    }
    public void stickFallingSound(){

    }
    public void heroFallingSound(){

    }
    public void heroReachingPillarEdge(){

    }
    public void collectCherriesSound(){

    }
    public void perfectPointSound(){

    }
    public void kickStickSound(){

    }
    public void turnUpsideSound(){

    }
}

package com.example.project1;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.*;
public class Music {
    public void backgroundConstant(){
        
            try {
                // Load the music file
                Media media = new Media(getClass().getResource("BackMusic.mp3").toString());

                // Create a MediaPlayer
                MediaPlayer mediaPlayer = new MediaPlayer(media);

                // Set to loop indefinitely
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

                // Play the music
                mediaPlayer.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    
    public void tapButton(){

    }
    public void stickIncreaseSound(){

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
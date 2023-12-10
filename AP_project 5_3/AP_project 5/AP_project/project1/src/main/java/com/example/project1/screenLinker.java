//package com.example.project1;
//
//import javafx.animation.TranslateTransition;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Group;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.image.ImageView;
//import javafx.stage.Stage;
//import javafx.fxml.Initializable;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.util.Duration;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//
//import java.io.IOException;
//
//public class screenLinker implements Initializable {
//    private MediaPlayer mediaPlayer;
//
//    private Stage stage;
//    private Scene scene;
//    private Parent root;
//
//    public void switchToScreen1(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//
//    }
//
//    public void switchToScreen2(ActionEvent event) throws IOException {
////        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//
//    }
//
//    @FXML
//    public ImageView backImage;
//    public Group stickMan;
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        TranslateTransition backImageTransition = new TranslateTransition();
//        backImageTransition.setNode(backImage);
//        backImageTransition.setByX(400);
//        backImageTransition.setDuration(Duration.millis(500));
//        backImageTransition.setCycleCount(2);
//        backImageTransition.play();
//
//        // Animation for stickMan
//        TranslateTransition stickManTransition = new TranslateTransition();
//        stickManTransition.setNode(stickMan);
//        stickManTransition.setByX(400);
//        stickManTransition.setDuration(Duration.millis(50));
//        stickManTransition.setCycleCount(2);
//        stickManTransition.play();
//
//
//    }
//
//    //    @Override
////    public void initialize(URL url, ResourceBundle resourceBundle) {
////        playBackgroundMusic();
////
////    }
//
//    void playBackgroundMusic() {
//        try {
//            // Load the music file
//            Media media = new Media(getClass().getResource("BackMusic.mp3").toString());
//
//            // Create a MediaPlayer
//            mediaPlayer = new MediaPlayer(media);
//
//            // Set to loop indefinitely
//            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
//
//            // Play the music
//            mediaPlayer.play();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//

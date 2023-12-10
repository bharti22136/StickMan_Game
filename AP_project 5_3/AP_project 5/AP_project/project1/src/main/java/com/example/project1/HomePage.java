package com.example.project1;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class HomePage implements Initializable {
    private BackgroundPicture backgroundPicture;
    private Music music=new Music();
    private HomePage homePage;
//    private MainGame mainPage;


    public void setMusic() {
        music.backgroundConstant();
    }

    public void titleName(){

    }
    public void playButton(){

    }

    public void setBackgroundPicture(BackgroundPicture backgroundPicture) {
        backgroundPicture.homeScreenPicture();
    }


    private Stage stage;
    private Scene scene;


    public void switchToScreen1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void handlePlayButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainPage.fxml"));
            Parent mainGameRoot = loader.load();
            MainGame mainGameController = new MainGame(); // Create an instance manually
            loader.setController(mainGameController);
            Timeline incrementStickLengthTimeline=mainGameController.getIncrementStickLengthTimeline();
            Scene mainGameScene = new Scene(mainGameRoot);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(mainGameScene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setMusic();
    }
}

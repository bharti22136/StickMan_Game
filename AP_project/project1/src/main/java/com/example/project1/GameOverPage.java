package com.example.project1;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.util.*;
public class GameOverPage {
    Music music=new Music();
    private BackgroundPicture backgroundPicture;

    public GameOverPage() {

    }

    public void setMusic(Music music) {
        music.backgroundConstant();
    }

    public void setBackgroundPicture(BackgroundPicture backgroundPicture) {
        backgroundPicture.gameOverPicture();
    }

    public void showBestScore(){

    }
    public void showScore(){

    }

    public void updateBestScore(){

    }
    @FXML
    public void restartGame(javafx.scene.input.MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainPage.fxml"));
            Parent mainGameRoot = loader.load();
            MainGame mainGameController = new MainGame(); // Create an instance manually
            loader.setController(mainGameController);
            Timeline incrementStickLengthTimeline=mainGameController.getIncrementStickLengthTimeline();
            Scene mainGameScene = new Scene(mainGameRoot);
            Stage stage = (Stage) ((javafx.scene.Node) mouseEvent.getSource()).getScene().getWindow();
            stage.setScene(mainGameScene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void goHomePage(javafx.scene.input.MouseEvent mouseEvent) {
            try {
                // Load the MainGame.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
                Parent homeRoot = loader.load();
                HomePage homeController = new HomePage(); // Create an instance manually
                loader.setController(homeController);
                Scene HomeScene = new Scene(homeRoot);
                Stage stage = (Stage) ((javafx.scene.Node) mouseEvent.getSource()).getScene().getWindow();
                stage.setScene(HomeScene);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }



}

package com.example.project1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private HomePage homePage;
    private MainGame mainPage;
    @Override
    public void start(Stage primaryStage) throws IOException {

//        Parent root = FXMLLoader.load(getClass().getResource("MainGame.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1270, 650);
        primaryStage.setTitle("Stick Hero Game");
        primaryStage.setScene(scene);

        // Get the controller instance and play background music
        primaryStage.setOnShown(e -> {
            // Get the controller instance and play background music
            homePage = loader.getController();
//            homePage.setMusic();


        });

        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }

}
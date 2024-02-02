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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1270, 650);
        primaryStage.setTitle("Stick Hero Game");
        primaryStage.setScene(scene);

        // Get the controller instance
        primaryStage.setOnShown(e -> {
            homePage = loader.getController();
        });
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

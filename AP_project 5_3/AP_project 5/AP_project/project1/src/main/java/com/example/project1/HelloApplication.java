package com.example.project1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

//import static org.junit.Assert.assertEquals;

public class HelloApplication extends Application {
    private HomePage homePage;
//    private MainGame mainPage;
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
            homePage.setMusic();


        });

        primaryStage.show();

    }
    public class CherryCollectorTest{

        @Test
        public void testCherryCount() {
            Cherries cherryCollector = Cherries.getInstance();

            cherryCollector.collectCherries(5); // Collect 5 cherries

            assertEquals(String.valueOf(5), cherryCollector.getCherryCount(), "Cherry count should be 5");
        }
    }

    public static void main(String[] args) {
        launch();
        Cherries cherryCollector = Cherries.getInstance();

        // Collecting cherries
        cherryCollector.collectCherries(10);
        cherryCollector.collectCherries(7);

        // Displaying the total collected cherries
        System.out.println("Total Cherries Collected: " + cherryCollector.getCherryCount());
    }
    public static class CherryCollector {
        private int cherryCount;

        public CherryCollector() {
            this.cherryCount = 0;
        }


    }}
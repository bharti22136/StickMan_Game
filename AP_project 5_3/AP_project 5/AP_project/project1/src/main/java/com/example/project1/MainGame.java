package com.example.project1;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import javafx.scene.transform.Rotate;
import java.util.*;
public class MainGame extends StickHero {
    private BackgroundPicture backgroundPicture;
    Timeline incrementStickLengthTimeline;
    boolean isEnterPressed=false;
    private boolean isRotated=false;

    private Music music=new Music();
//    ArrayList<Rectangle> pillarList=new ArrayList<>();
//private static Map<Rectangle, Pillars> pillarList = new HashMap<Rectangle, Pillars>();


    @FXML
    Line stick;
    @FXML
    public VBox outerVBox;
    public ImageView backImage1;
    @FXML
    public ImageView backImage2;
    @FXML
    public Group stickMan;
    @FXML
    public ImageView man1 ;
    @FXML
    public ImageView man2 ;
    @FXML
    public ImageView man3 ;
    @FXML
    public Group man;
    @FXML
    public Rectangle stickRectangle;

    @FXML
    public Rectangle stickRectangle1;
    @FXML
    public Rectangle stickRectangle2;

    @FXML
    public Rectangle stickRectangle3;
    public StickHero stickHero;

//    Pillars pillars=Pillars.getInstance(Rectangle r);
    public MainGame() {
        super(0, 0, 0); // You may need to provide appropriate default values
    }
    public MainGame(double x, double y, double xVelocity) {
        super(x, y, xVelocity);
    }




    public void showScore(){

    }
    public void showTotalCherries(){

    }

    public void setBackgroundPicture(BackgroundPicture backgroundPicture) {
        backgroundPicture.mainBackgroundPicture();
    }

    public void setMusic() {
        music.backgroundConstant();
    }
    public void isPerfectPoint(){

    }




    @FXML
    public void initialize() {
//        super.initialize(incrementStickLengthTimeline);
        outerVBox.setOnKeyPressed(this::enterPressed);
        outerVBox.setFocusTraversable(true);
        outerVBox.requestFocus();
//        addInPillarList();


        Image backgroundImage = new Image(getClass().getResourceAsStream("backwall.jpg"));
        backImage1.setImage(backgroundImage);
        backImage2.setImage(backgroundImage);

        // Set up TranslateTransitions for the background images
        TranslateTransition backImageTransition1 = createBackgroundTransition(backImage1);
        TranslateTransition backImageTransition2 = createBackgroundTransition(backImage2);

        // Set up a Timeline to create a loop
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, event -> {
                    // Set the initial positions of the background images
                    backImage1.setTranslateX(0);
                    backImage2.setTranslateX(backImage1.getBoundsInParent().getWidth());
                    // Start the TranslateTransitions
                    backImageTransition1.playFromStart();
                    backImageTransition2.playFromStart();
                }),
                new KeyFrame(Duration.seconds(4)) // You can adjust the duration
        );
        timeline.setCycleCount(Timeline.INDEFINITE); // Infinite loop
        timeline.play();

//         Animation for stickMan

        setMusic();

        //Timeline for Incrementing Stick
        increaseStick();
        Duration stickIncrementDuration = Duration.millis(16);
        incrementStickLengthTimeline = new Timeline(new KeyFrame(stickIncrementDuration, event -> {

            if (isEnterPressed) {
                increaseStick();
            }
        }));
        incrementStickLengthTimeline.setCycleCount(Timeline.INDEFINITE);
    }
    public void increaseStick(){


            incrementStickLength(stickRectangle,stickMan);


    }
    @FXML
    public void enterPressed(KeyEvent event1) {

        if (event1.getCode() == KeyCode.ENTER && event1.getEventType() == KeyEvent.KEY_PRESSED) {
            isEnterPressed = true;

            incrementStickLengthTimeline.play();


        } else if (event1.getCode() == KeyCode.ENTER && event1.getEventType() == KeyEvent.KEY_RELEASED) {
            isEnterPressed = false;
            // Stop growStickTimeline when enter is released
            incrementStickLengthTimeline.stop();
            // Rotate the stick when enter is released
            stickFallDown(stickRectangle,stickMan);

        }
        else if (event1.getCode() == KeyCode.SHIFT) {
            if (event1.isShiftDown()) {
                // Rotate heroGroup by 180 degrees when shift is pressed
                rotateHeroGroup();
            }
            // Consume event to prevent unwanted behavior in the application
            event1.consume();
        }
        else{
            System.out.println("jhfjhfjhf");
        }
    }



    private TranslateTransition createBackgroundTransition(ImageView imageView) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(imageView);
        transition.setByX(-imageView.getBoundsInParent().getWidth());
        transition.setDuration(Duration.seconds(4)); // You can adjust the duration
        return transition;
    }
    private void rotateHeroGroup() {
        if (!isRotated) {
            // Rotate heroGroup by 180 degrees
            stickMan.setRotate(stickMan.getRotate() + 180);
        } else {
            // Reverse the rotation by 180 degrees
            stickMan.setRotate(stickMan.getRotate() - 180);
        }
        // Toggle rotation state
        isRotated = !isRotated;
    }

    public Timeline getIncrementStickLengthTimeline(){
        System.out.println();
        return incrementStickLengthTimeline;
    }
//    public void addInPillarList(){
//        pillarList.add(pillar1);
//        pillarList.add(pillar2);
//        pillarList.add(pillar3);
//        pillarList.add(pillar4);
//    }
//    private void checkCollision() {
//        // Get bounds of stickHero and cherryImage
//        Bounds stickHeroBounds = stickHero.getBoundsInParent();
//        Bounds cherryBounds = cherryImage.getBoundsInParent();
//
//        // Check for collision
//        if (stickHeroBounds.intersects(cherryBounds)) {
//            handleCollision();
//        }
//    }

//    private void handleCollision() {
//        // Increment the counter and update the UI or perform any other actions
//        cherriesCollected++;
//        System.out.println("Cherries Collected: " + cherriesCollected);
//
//        // You can add more logic here, such as removing the cherryImage, updating the score, etc.
//        // For example:
//        cherriesPane.getChildren().remove(cherryImage);
//    }
//    public void switchToScorePage() {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("scorepage.fxml"));
//            Parent scorePageRoot = loader.load();
//            StickHero scorePageController = loader.getController();
//            // You can pass any necessary data to the score page controller if needed
//
//            Scene scorePageScene = new Scene(scorePageRoot);
//            Stage stage = (Stage) outerVBox.getScene().getWindow(); // Assuming outerVBox is part of the scene
//            stage.setScene(scorePageScene);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}

package com.example.project1;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;
public class MainGame extends StickHero {
    private BackgroundPicture backgroundPicture;
    Timeline incrementStickLengthTimeline;
    boolean isEnterPressed=false;
    private Music music=new Music();
    public Rectangle rectangle0;

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
    public ImageView cherryImage1;
    @FXML
    public ImageView man1 ;
    @FXML
    public ImageView man2 ;
    @FXML
    public ImageView man3 ;
    @FXML
    public Group man;
    @FXML
    public VBox cherriesPane;
//    @FXML
//    private Text currentScore1;
    @FXML
    public Rectangle stickRectangle;

    @FXML
    public Rectangle stickRectangle1;
    @FXML
    public Rectangle stickRectangle2;
    @FXML
    public int numberOfCherriesCollected=0;

    @FXML
    public Rectangle stickRectangle3;

    List<Rectangle> stickList;
    List<Rectangle> pillarList=Arrays.asList(pillar1,pillar2,pillar3,pillar4);

    Timeline[] incrementStickLengthTimelines;
    Rectangle[] stickRectangles;

//    Pillars pillars=Pillars.getInstance();
    public MainGame() {
        super(0, 0, 0);
        initializeStickList();
    }
    public MainGame(double x, double y, double xVelocity) {
        super(x, y, xVelocity);
    }
    private void initializeStickList() {
        stickList = Arrays.asList(stickRectangle, stickRectangle1, stickRectangle2, stickRectangle3);
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
        initializeStickList();
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
        setMusic();


        incrementStickLengthTimelines = new Timeline[stickList.size()];
        stickRectangles = new Rectangle[stickList.size()];


        for (int i = 0; i < stickList.size(); i++) {
            Rectangle currentRectangle = stickList.get(i);
            stickRectangles[i] = currentRectangle;

            // Initialize each timeline for incrementing the stick
            incrementStickLengthTimelines[i] = createIncrementStickTimeline(currentRectangle);

            // Set up a callback to move to the next element
            if (i < stickList.size() - 1) {
                int nextIndex = i + 1;
                incrementStickLengthTimelines[i].setOnFinished(e -> incrementStickLengthTimelines[nextIndex].play());
            }
        }
    }

    private Timeline createIncrementStickTimeline(Rectangle rectangle) {
        Duration stickIncrementDuration = Duration.millis(10);
        Timeline timeline1 = new Timeline(new KeyFrame(stickIncrementDuration, event -> {
            if (isEnterPressed && !isFallen) {
                incrementStickLength(rectangle, stickMan);
            } else {
                // Stick has fallen, stop the timeline for this rectangle
                timeline1.stop();
            }
        }));
        timeline1.setCycleCount(Timeline.INDEFINITE);
        return timeline1;
    }


    public void increaseStick(Rectangle rectangle){

        System.out.println(isStickRotated());
        if (isStickRotated()) {
            Arrays.stream(incrementStickLengthTimelines).forEach(Timeline::stop);
            isStickRotated = false;
        } else {
            incrementStickLength(rectangle, stickMan);
        }

    }

    @FXML
    public void enterPressed(KeyEvent event1) {

        if (event1.getCode() == KeyCode.ENTER && event1.getEventType() == KeyEvent.KEY_PRESSED && !isStickRotated()) {
            isEnterPressed = true;
            Arrays.stream(incrementStickLengthTimelines).forEach(Timeline::play);
            music.stickIncreaseSound();
        }

        if (event1.getCode() == KeyCode.ENTER && event1.getEventType() == KeyEvent.KEY_RELEASED) {
            isEnterPressed = false;
            Arrays.stream(incrementStickLengthTimelines).forEach(Timeline::stop);
            Arrays.stream(stickRectangles).forEach(rectangle -> stickFallDown(rectangle, stickMan));
        } else {
            Arrays.stream(stickRectangles).forEach(this::increaseStick);
        }
    }


    private TranslateTransition createBackgroundTransition(ImageView imageView) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(imageView);
        transition.setByX(-imageView.getBoundsInParent().getWidth());
        transition.setDuration(Duration.seconds(4)); // You can adjust the duration
        return transition;
    }
    public Timeline getIncrementStickLengthTimeline(){
        return incrementStickLengthTimeline;
    }
    @FXML
    public void goToEndGamePage(ActionEvent event) {
        try {
            // Load the MainGame.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("scorepage.fxml"));
            Parent endGameRoot = loader.load();
            GameOverPage endGameController = new GameOverPage(); // Create an instance manually
            loader.setController(endGameController);
            Scene mainGameScene = new Scene(endGameRoot);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(mainGameScene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

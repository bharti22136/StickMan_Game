package com.example.project1;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StickHero implements Stick {
    private double x,y,xVelocity;
    public Music music1=new Music();
    private Score score;
    private Cherries cherries;
    private Line stick;

    boolean isStickRotated;
    boolean fallenStatus=false;
    boolean isFallen=false;
    boolean isStickFallen=false;
    private boolean extendingStick = false;
    private static final double STICK_EXTENSION_SPEED = 5;
    Parent mainGameRoot;
    int currentscore=0;
    int bestScore=0;
    public StickHero(double x,double y,double xVelocity) {

        this.x = x;
        this.y=y;
        this.xVelocity=xVelocity;
    }

    @FXML
    public Rectangle pillar1;
    @FXML
    public Rectangle pillar2;
    @FXML
    public Rectangle pillar3;
    @FXML
    public Rectangle pillar4;
    @FXML
    public Rectangle PP1;
    @FXML
    public Rectangle PP2;
    @FXML
    public Rectangle PP3;
    @FXML
    public Rectangle PP4;


    @Override
    public void incrementStickLength(Rectangle stickRectangle,Group stickMan) {
        System.out.println("inside stick hero");
        if (stickRectangle != null ) {
            System.out.println("stick not null");
            double originalY = stickRectangle.getY();
            double originalHeight = stickRectangle.getHeight();

            stickRectangle.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER && !isStickFallen) {
                    double increment = 1; // Change the increment as needed
                    stickRectangle.setHeight(originalHeight + increment);
                    stickRectangle.setY(originalY - increment);
//                    music1.stickIncreaseSound();
                    System.out.println("here====================");

                }
            });

                stickRectangle.setOnKeyReleased(event -> {
                    if (event.getCode() == KeyCode.ENTER) {
                        // Set the flag to true when the space bar is released
                        isStickRotated = true;
                        stickFallDown(stickRectangle,stickMan); // Rotate the stick when the space bar is released
                    }
                });

            stickRectangle.setFocusTraversable(true); // Allow the rectangle to receive key events
        }
    }


    @Override
    public void checkStickLength(){

    }
    @Override
    public void traverseStickDistance(){

    }
    @Override
    public boolean perfectLength(){
        return true;
    }
    @Override
    public void stickFallDown(Rectangle stickRectangle,Group stickMan){
        if (isStickRotated && stickRectangle != null && !isStickFallen) {
            double pivotX = stickRectangle.getX();
            double pivotY = stickRectangle.getY() + stickRectangle.getHeight();
            double stickHeight=stickRectangle.getHeight();
            Rotate rotation = new Rotate(90, pivotX, pivotY);
            stickRectangle.getTransforms().add(rotation);
//            isStickRotated = false;
            isStickFallen=true;
            isFallen= moveHero(stickMan,stickHeight);
        }


    }
    public boolean moveHero(Group stickMan,double stickHeight){
        TranslateTransition stickManTransition = new TranslateTransition();
        stickManTransition.setNode(stickMan);
        if((pillar2.getLayoutX()-(pillar1.getLayoutX()+pillar1.getWidth()))>stickHeight  || (pillar2.getLayoutX()-(pillar1.getLayoutX()+pillar1.getWidth())+pillar2.getWidth())<stickHeight){
            stickManTransition.setByX(stickHeight);

        }
        else{
            stickManTransition.setByX(pillar2.getLayoutX()+pillar2.getWidth()-pillar1.getWidth()-pillar1.getLayoutX());
        }

        stickManTransition.setDuration(Duration.millis(60));
        stickManTransition.setCycleCount(2);
        stickManTransition.play();

        if((pillar2.getLayoutX()-(pillar1.getLayoutX()+pillar1.getWidth()))>stickHeight  || (pillar2.getLayoutX()-(pillar1.getLayoutX()+pillar1.getWidth())+pillar2.getWidth())<stickHeight){
            fallDown(stickMan);
            System.out.println("fall");
        }
        else{
            System.out.println("not falling");

        }
        return isFallen;

    }
    public void stopHero(){

    }
    public void kickTheStick(){

    }
    public void fallDown(Group stickMan){
        System.out.println("fall down");
        TranslateTransition stickManTransition = new TranslateTransition();
        stickManTransition.setNode(stickMan);
        stickManTransition.setByY(100);
        stickManTransition.play();
        isFallen=true;

    }
    public boolean isStickRotated() {
        return isStickRotated;
    }
    public void flipDown(){

    }
    public void flipUp(){

    }
    public void moveCap(){

    }





}

package com.example.project1;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;
public class StickHero implements Stick {
    private double x,y,xVelocity;
    private Score score;
    private Cherries cherries;
    private Line stick;
    boolean isStickRotated=false;
    private boolean extendingStick = false;
//    private static final double ROTATION_ANGLE = 180.0;
    private static final double STICK_EXTENSION_SPEED = 5;
    Parent mainGameRoot;
    private double rotate = 0;
//    public MainGame mainGame;
    public void setRotate(double rotate) {
        this.rotate = rotate;
        // Assuming stickHero is a Node or any class with setRotate method
        stickHero.setRotate(rotate);
    }

    public double getRotate() {
        return rotate;
    }
    public StickHero stickHero;
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
        if (stickRectangle != null) {
            double originalY = stickRectangle.getY(); // Store the original y-coordinate
            double originalHeight = stickRectangle.getHeight(); // Store the original height

            stickRectangle.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    double increment = 1; // Change the increment as needed
                    stickRectangle.setHeight(originalHeight + increment); // Increase height
                    // Adjust y-coordinate to keep the left lower corner at the same position
                    stickRectangle.setY(originalY - increment);
                }
            });

            stickRectangle.setOnKeyReleased(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    // Set the flag to true when the space bar is released
                    isStickRotated = true;
//                    mainGame.switchToScorePage();
                    stickFallDown(stickRectangle,stickMan); // Rotate the stick when the space bar is released
                }
            });
            stickRectangle.setFocusTraversable(true); // Allow the rectangle to receive key events
        }
    }
    boolean result=false;


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
        if (isStickRotated && stickRectangle != null) {
            double pivotX = stickRectangle.getX();
            double pivotY = stickRectangle.getY() + stickRectangle.getHeight();
            double stickHeight=stickRectangle.getHeight();
            Rotate rotation = new Rotate(90, pivotX, pivotY);
            stickRectangle.getTransforms().add(rotation);

            // Reset the flag for the next rotation

            moveHero(stickMan,stickHeight);
        }
    }
    public void moveHero(Group stickMan,double stickHeight){
        TranslateTransition stickManTransition = new TranslateTransition();
        stickManTransition.setNode(stickMan);
        if((pillar2.getLayoutX()-(pillar1.getLayoutX()+pillar1.getWidth()))>stickHeight  || (pillar2.getLayoutX()-(pillar1.getLayoutX()+pillar1.getWidth())+pillar2.getWidth())<stickHeight){
            isStickRotated = false;
            stickManTransition.setByX(stickHeight);
            System.out.println("fall hoga");
        }
        else{
            System.out.println("kjdsffjs");
            stickManTransition.setByX(pillar2.getLayoutX()+pillar2.getWidth()-pillar1.getWidth()-pillar1.getLayoutX());
        }

        stickManTransition.setDuration(Duration.millis(60));
        stickManTransition.setCycleCount(2);
        stickManTransition.play();
        System.out.println(pillar1.getLayoutX());
        System.out.println(pillar1.getWidth());
        System.out.println(pillar2.getLayoutX());
        System.out.println(pillar2.getWidth());
        System.out.println(stickHeight);
        System.out.println((pillar2.getLayoutX()-(pillar1.getLayoutX()+pillar1.getWidth())));
        System.out.println((pillar2.getLayoutX()-(pillar1.getLayoutX()+pillar1.getWidth())+pillar2.getWidth()));
        if((pillar2.getLayoutX()-(pillar1.getLayoutX()+pillar1.getWidth()))>stickHeight  || (pillar2.getLayoutX()-(pillar1.getLayoutX()+pillar1.getWidth())+pillar2.getWidth())<stickHeight){
            result=true;
            fallDown(stickMan);
            System.out.println("fall");
        }
        else{
            System.out.println("not falling");
        }
    }
    public void stopHero(){

    }
    public void kickTheStick(){

    }

    public boolean fallDown(Group stickMan){
        TranslateTransition stickManTransition = new TranslateTransition();
        stickManTransition.setNode(stickMan);
        stickManTransition.setByY(100);
        stickManTransition.play();
        return result;
    }
    public void flipDown(){

    }
    public void flipUp(){

    }
    public void moveCap(){

    }

}

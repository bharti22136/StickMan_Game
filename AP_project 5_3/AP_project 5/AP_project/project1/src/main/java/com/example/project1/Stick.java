package com.example.project1;

import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public interface Stick {
    public void incrementStickLength(Rectangle rectangle, Group stickMan);
    public void checkStickLength();
    public void traverseStickDistance();
    public boolean perfectLength();
    public void stickFallDown(Rectangle rectangle,Group stickMan);

}

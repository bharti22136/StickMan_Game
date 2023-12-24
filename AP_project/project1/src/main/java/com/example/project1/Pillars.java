package com.example.project1;
//package com.example.project1;
import java.awt.*;
import java.util.*;
import javafx.scene.shape.Rectangle;
public class Pillars {    // Flyweight design pattern is used in this
    private static int pillarHeight=20;
    private int pillarWidth;
    private int distanceBetweenPillars;
    private float perfectPoint;
    private int pillarXVelocity;

    //    private static Pillars pillars;
    private static Map<Rectangle, Pillars> pillarList = new HashMap<Rectangle, Pillars>();


    public Pillars(Rectangle rectangle) {
        this.pillarWidth=pillarWidth;
        this.pillarHeight=pillarHeight;
        this.distanceBetweenPillars=distanceBetweenPillars;
        this.perfectPoint=perfectPoint;
        this.pillarXVelocity=pillarXVelocity;

    }
    //    public static Pillars getInstance(){      // Singleton Design Pattern is used here
//        if(pillars==null){
//            pillars=new Pillars();
//        }
//        return pillars;
//    }
    public static Pillars getInstance(Rectangle key) {
        if (!pillarList.containsKey(key)) {
            pillarList.put(key, new Pillars(key));
        }
        return pillarList.get(key);
    }


    public void setPillarMotion(int pillarXVelocity) {
        this.pillarXVelocity = pillarXVelocity;
    }

    public int getDistanceBetweenPillars() {
        return distanceBetweenPillars;
    }

    public void setDistanceBetweenPillars(int distanceBetweenPillars) {
        distanceBetweenPillars = distanceBetweenPillars;
    }

    public int getPillarWidth() {
        return pillarWidth;
    }

    public void setPillarWidth(int pillarWidth) {
        this.pillarWidth = pillarWidth;
    }

    public float getPerfectPoint() {
        return perfectPoint;
    }

    public void setPerfectPoint(float perfectPoint) {
        this.perfectPoint = perfectPoint;
    }

}
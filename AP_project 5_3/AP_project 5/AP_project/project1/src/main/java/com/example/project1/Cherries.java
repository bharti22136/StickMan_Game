package com.example.project1;

public class Cherries {   // Singleton design pattern is used here
    private double  x_coordinate,y_coordinate;
    private static Cherries gen=null;
    private int cherryCount;

    private Cherries() {
        this.x_coordinate = x_coordinate;
        this.y_coordinate=y_coordinate;
    }
    public static Cherries getInstance(){
        if(gen==null){
            gen=new Cherries();
        }
        return gen;
    }

    public double getX_coordinate() {
        return x_coordinate;
    }

    public void setX_coordinate(double x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public double getY_coordinate() {
        return y_coordinate;
    }

    public void setY_coordinate(double y_coordinate) {
        this.y_coordinate = y_coordinate;
    }
    public void collectCherries(int cherries) {
        cherryCount += cherries;
    }

    public int getCherryCount() {
        return cherryCount;}
    public void incrementCherry(){

    }
    public boolean validateCherry(){
        return true;
    }
}

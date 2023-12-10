////package com.example.project1;
////
////import javafx.application.Application;
////import javafx.event.ActionEvent;
////import javafx.event.EventHandler;
////import javafx.fxml.FXMLLoader;
////import javafx.scene.Parent;
////import javafx.scene.Scene;
////import javafx.scene.control.Button;
////import javafx.scene.control.Label;
////import javafx.scene.layout.VBox;
////import javafx.scene.paint.Paint;
////import javafx.scene.text.Font;
////import javafx.stage.Stage;
////import javafx.scene.Group;
////import javafx.scene.paint.Color;
////import javafx.scene.image.Image;
////import javafx.scene.image.ImageView;
////import javafx.scene.text.Text;
////import javafx.scene.shape.Line;
////import javafx.scene.layout.Pane;
////import javafx.animation.KeyFrame;
////import javafx.animation.Timeline;
////import javafx.util.Duration;
////
////
//////import javax.sound.sampled.Line;
////import javafx.scene.input.MouseEvent;
//////import java.awt.event.MouseEvent;
////import java.io.IOException;
////
////public class HelloApplication extends Application {
////    private HomePage homePage;
////    private Line stick;
////    private boolean extendingStick = false;
////
////    private static final double PLATFORM_WIDTH = 200;
////    private static final double PLATFORM_HEIGHT = 10;
////    private static final double STICK_EXTENSION_SPEED = 5;
////    private Pane root;
////
////    @Override
////    public void start(Stage primaryStage) throws IOException {
////
//////        Parent root = FXMLLoader.load(getClass().getResource("MainGame.fxml"));
////        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
//////        root = loader.load();
////
////        root=new Pane();
////        Scene scene = new Scene(root, 1270, 650);
////        primaryStage.setTitle("Stick Hero Game");
////        primaryStage.setScene(scene);
//////        primaryStage.show();
////
////        // Get the controller instance and play background music
////        screenLinker controller = loader.getController();
//////        controller.playBackgroundMusic();
////        stick = new Line();
////        stick.setStroke(Color.BLACK);
////        stick.setStrokeWidth(10);
////
////        scene.setOnMousePressed(this::handleMousePress);
////        scene.setOnMouseReleased(this::handleMouseRelease);
////
////        (root).getChildren().add(stick);
////        primaryStage.setScene(scene);
////        primaryStage.setTitle("Stick Hero Game");
////        primaryStage.show();
////    }
////
////
//////    private void drawPlatform() {
//////        // Draw a simple platform
//////        javafx.scene.shape.Rectangle platform = new javafx.scene.shape.Rectangle(
//////                (root.getWidth() - PLATFORM_WIDTH) / 2,
//////                root.getHeight() - PLATFORM_HEIGHT,
//////                PLATFORM_WIDTH,
//////                PLATFORM_HEIGHT
//////        );
//////        root.getChildren().add(platform);
//////    }
////
////    private void handleMousePress(MouseEvent event) {
////        if (!extendingStick) {
////            extendingStick = true;
////            extendStick();
////        }
////    }
////
////    private void handleMouseRelease(MouseEvent event) {
////        extendingStick = false;
////    }
////
////    private void extendStick() {
////        System.out.println("Extending stick");
////
////        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(16), e -> {
////            if (extendingStick && stick.getEndX() < ( root).getWidth()) {
////                stick.setEndX(stick.getEndX() + STICK_EXTENSION_SPEED);
////                stick.setStrokeWidth(stick.getStrokeWidth() + STICK_EXTENSION_SPEED); // Adjust this value
////            }
////        }));
////        timeline.setCycleCount(Timeline.INDEFINITE);
////        timeline.play();
////    }
////
////
////
////
////
////    public static void main(String[] args) {
////        launch(args);
////    }
////
////}
//
//    final static javafx.scene.image.Image Man1=new javafx.scene.image.Image(StickHero.class.getResource("s1.png").toString());
//    final static javafx.scene.image.Image Man2=new javafx.scene.image.Image(StickHero.class.getResource("s2.png").toString());
//    final static javafx.scene.image.Image Man3=new javafx.scene.image.Image(StickHero.class.getResource("s3.png").toString());
//    final static javafx.scene.image.Image Man4=new javafx.scene.image.Image(StickHero.class.getResource("s4.png").toString());
//    final static javafx.scene.image.Image Man5=new javafx.scene.image.Image(StickHero.class.getResource("s5.png").toString());
//    final static javafx.scene.image.Image Man6=new javafx.scene.image.Image(StickHero.class.getResource("s6.png").toString());
//    final static javafx.scene.image.Image Man7=new javafx.scene.image.Image(StickHero.class.getResource("s7.png").toString());
//    private Group man;
//    public void start(Stage primaryStage) throws IOException{
//        final ImageView man1=new ImageView(Man1);
//        final ImageView man2=new ImageView(Man2);
//        final ImageView man3=new ImageView(Man3);
//        final ImageView man4=new ImageView(Man4);
//        final ImageView man5=new ImageView(Man5);
//        final ImageView man6=new ImageView(Man6);
//        final ImageView man7=new ImageView(Man7);
//        man=new Group(man1);
//        man.setTranslateX(200);
//        Timeline t=new Timeline();
//        t.setCycleCount(Timeline.INDEFINITE);
//        t.getKeyFrames().add(new KeyFrame(
//                Duration.millis(200),
//                (ActionEvent event) -> {
//                    man.getChildren().setAll(man1);
//                }
//        ));
//        t.getKeyFrames().add(new KeyFrame(
//                Duration.millis(300),
//                (ActionEvent event) -> {
//                    man.getChildren().setAll(man2);
//                }
//        ));
//        t.getKeyFrames().add(new KeyFrame(
//                Duration.millis(400),
//                (ActionEvent event) -> {
//                    man.getChildren().setAll(man3);
//                }
//        ));
//        t.getKeyFrames().add(new KeyFrame(
//                Duration.millis(500),
//                (ActionEvent event) -> {
//                    man.getChildren().setAll(man4);
//                }
//        ));
//        t.getKeyFrames().add(new KeyFrame(
//                Duration.millis(600),
//                (ActionEvent event) -> {
//                    man.getChildren().setAll(man5);
//                }
//        ));
//        t.getKeyFrames().add(new KeyFrame(
//                Duration.millis(700),
//                (ActionEvent event) -> {
//                    man.getChildren().setAll(man6);
//                }
//        ));
//        t.getKeyFrames().add(new KeyFrame(
//                Duration.millis(800),
//                (ActionEvent event) -> {
//                    man.getChildren().setAll(man7);
//                }
//        ));
//        t.play();
//    }

package com.mycompany.lab07;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        Pane animationPane = new Pane();
        
        Rectangle rect = new Rectangle(20, 20, 600, 400);
        rect.setArcHeight(50);
        rect.setArcWidth(50);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.BLACK);
        
        Circle circ = new Circle(20, Color.AQUA);
        circ.setCenterX(20);
        circ.setCenterY(20);
        
        Ellipse ellipse = new Ellipse(80, 40);
        ellipse.setFill(Color.BURLYWOOD);
        ellipse.setCenterX(320);
        ellipse.setCenterY(230);
        
        Path path = new Path();
        
        path.getElements().add(new MoveTo(20, 20));
        path.getElements().add(new LineTo(620, 20));
        path.getElements().add(new LineTo(620, 420));
        path.getElements().add(new LineTo(20, 420));
        path.getElements().add(new LineTo(20, 20));
        
        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(circ);
        pathTransition.setPath(path);
        pathTransition.setDuration(Duration.millis(8000));
        pathTransition.setCycleCount(1);
        
        FadeTransition fade = new FadeTransition(
                Duration.seconds(2.25),
                ellipse
        );

        fade.setFromValue(1.0);
        fade.setToValue(0.2);
        
        ScaleTransition scale = new ScaleTransition(
                Duration.seconds(2),
                ellipse
        );

        scale.setFromX(1.0);
        scale.setFromY(1.0);
        scale.setToX(2.0);
        scale.setToY(2.0);
        
        RotateTransition rotate = new RotateTransition(
                Duration.seconds(2),
                ellipse
        );

        rotate.setToAngle(0.0);
        rotate.setFromAngle(360.0);
        
        TranslateTransition translation = new TranslateTransition(
                Duration.seconds(2),
                ellipse
        );
         
        translation.setToY(100);
        
        SequentialTransition sequentialTransition = new SequentialTransition(
                fade,
                scale,
                rotate,
                translation
        );
        
        animationPane.getChildren().addAll(
                rect,
                circ,
                ellipse
        );
        
        Button start = new Button("Start");
        Button reset = new Button("Reset");
        Button exit = new Button("Exit");
        
        HBox buttons = new HBox(10);
        buttons.getChildren().addAll(
                start,
                reset,
                exit
        );
        
        buttons.setAlignment(Pos.CENTER);
        
        start.setOnAction(e -> {
            pathTransition.play();
            sequentialTransition.play();
            start.setDisable(true);
        });
        
        reset.setOnAction(e -> {
            pathTransition.stop();
            sequentialTransition.stop();

            ellipse.setCenterX(320);
            ellipse.setCenterY(230);
            ellipse.setOpacity(1.0);
            ellipse.setScaleX(1.0);
            ellipse.setScaleY(1.0);
            ellipse.setTranslateY(0);
            
            start.setDisable(false);
        });
        
        exit.setOnAction(e -> {
            stage.close();
        });
        
        root.setCenter(animationPane);
        root.setBottom(buttons);
        
        Scene scene = new Scene(root, 650, 450);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
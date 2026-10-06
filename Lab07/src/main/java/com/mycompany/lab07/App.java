package com.mycompany.lab07;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
        Pane root = new Pane();
        
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
        
        pathTransition.play();
        
        FadeTransition fade = new FadeTransition(
                Duration.seconds(2),
                ellipse
        );

        fade.setFromValue(1.0);
        fade.setToValue(0.2);
        
        root.getChildren().addAll(
                rect,
                circ,
                ellipse
        );
        
        Scene scene = new Scene(root, 650, 450);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
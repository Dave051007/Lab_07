package com.mycompany.lab07;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


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
        
        Circle circ = new Circle(50, Color.AQUA);
        
        root.getChildren().addAll(
                rect,
                circ
        );
        
        
        Scene scene = new Scene(root, 650, 450);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
package com.example.proxy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private ProxyImage proxyImage;

    @Override
    public void start(Stage stage) {
        proxyImage = new ProxyImage(new Image("img.jpg"));
        Group group = new Group(proxyImage.rectangleImage);
        proxyImage.rectangleImage.setOnMouseDragged(b -> {
            Translate translate = new Translate();
            translate.setX(b.getX() - proxyImage.rectangleImage.getWidth());
            translate.setY(b.getY() - proxyImage.rectangleImage.getHeight());
            proxyImage.rectangleImage.getTransforms().addAll(translate);
        });

        proxyImage.rectangleImage.addEventFilter(MouseEvent.MOUSE_PRESSED, c -> {
            if (c.isSecondaryButtonDown()) {
                proxyImage.setSize((int) proxyImage.getImage().getWidth(), (int) proxyImage.getImage().getHeight());
                proxyImage.draw();

            }
        });

        stage.setScene(new Scene(group));
        stage.setWidth(1920);
        stage.setHeight(1080);
        stage.setTitle("Proxy");
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
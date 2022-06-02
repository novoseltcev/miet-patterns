package com.example.proxy;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class RealImage implements CustomImage{
    private final Image image;
    public Rectangle rectangleImage;

    RealImage(Image image, Rectangle rectangleImage){
        this.image = image;
        this.rectangleImage = rectangleImage;
        //rectangleImage =new Rectangle(100,100,rectangleImage.getWidth(),rectangleImage.getHeight());
    }

    public void draw(){
        rectangleImage.setFill(new ImagePattern(image));
    }
}
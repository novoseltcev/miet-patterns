package com.example.proxy;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class ProxyImage implements CustomImage {
    private final Image image;
    public Rectangle rectangleImage;
    private RealImage realImage;

    ProxyImage(Image image){
        this.image = image;
        rectangleImage = new Rectangle(500,500,500,500);
    }

    public void draw(){
        if(realImage == null){
            realImage = new RealImage(image, rectangleImage);
        }
        realImage.draw();
    }


    public void setSize(int width, int height) {
         rectangleImage.setWidth(width);
         rectangleImage.setHeight(height);
    }

    public Image getImage() {
        return image;
    }
}
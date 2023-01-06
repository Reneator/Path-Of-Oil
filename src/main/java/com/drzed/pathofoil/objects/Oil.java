package com.drzed.pathofoil.objects;

import javafx.scene.image.Image;

public class Oil {

    String name;
    Image image;

    String filePath;

    public Oil(String name) {
        this.name = name;
        this.filePath = "file:data/imgs/" + this.name + ".png";
        this.image = new Image(this.filePath);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}

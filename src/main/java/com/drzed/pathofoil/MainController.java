package com.drzed.pathofoil;

import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainController {
    public ImageView oil1;
    public ImageView oil2;
    public ImageView oil3;
    public Stage stage;

    public void updatePictures() {
        clearOilImages();

        // Sanity Check
        if (!POO.anointmentsMasterList.containsKey(POO.currentItem)) {
            System.out.println("NO EXIST : " + POO.currentItem);
        }

        String[] oils = POO.anointmentsMasterList.get(POO.currentItem).split(",");
        for (int i = 0; i < oils.length; i++) {
            if (i == 0) {
                oil1.setImage(POO.getOilImage(oils[i]));
            }
            if (i == 1) {
                oil2.setImage(POO.getOilImage(oils[i]));
            }
            if (i == 2) {
                oil3.setImage(POO.getOilImage(oils[i]));
            }
        }
    }

    private void clearOilImages() {
        // Clears images before displaying new ones so if you did amulet (3 oils)
        //      then ring (2 oils) the 3rd oil won't remain the one from the amulet
        oil1.setImage(null);
        oil2.setImage(null);
        oil3.setImage(null);
    }

    // Enables moving window since it's an Undecorated one (fake title bar in place)
    double xOffset, yOffset;
    public void onDrag(MouseEvent mouseEvent) {
        stage.setX(mouseEvent.getScreenX() + xOffset);
        stage.setY(mouseEvent.getScreenY() + yOffset);
    }

    public void onPress(MouseEvent mouseEvent) {
        xOffset = stage.getX() - mouseEvent.getScreenX();
        yOffset = stage.getY() - mouseEvent.getScreenY();
    }

    public void onQuit() {
        Platform.exit();
        System.exit(0);
    }
}
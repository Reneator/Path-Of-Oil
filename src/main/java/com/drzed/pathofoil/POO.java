package com.drzed.pathofoil;

import com.drzed.pathofoil.objects.Anointments;
import com.drzed.pathofoil.objects.Oils;
import com.drzed.pathofoil.objects.PoeItem;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.io.*;
import java.util.HashMap;

public class POO extends Application {

    public static final Oils oils = new Oils();

    public static Anointments anointments;

    public static HashMap<String, String> anointmentsMasterList = new HashMap<>();
    public static PoeItem currentItem;

    public MainController controller;

    public static void main(String[] args) throws IOException {
        initializeData();
        launch();
    }




    private static void initializeData() throws IOException {
        // Loads pre-populated and trimmed spreadsheets of oils and their associated anoint
        anointments = new Anointments("./data/Amulets.csv");

    }

    @Override
    public void start(Stage stage) throws IOException {
        initializeUI(stage);

        new Thread(() -> {
            while (true) {
                try {
                    // Grab Clipboard Contents
                    String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
                    analyzeClipBoard(data);
                    // Sleep exactly 10 frames (60 fps is 16.7ms per frame)
                    // In all reality this is to save CPU and has no noticeable delay of CTRL+C -> display oils
                    Thread.sleep(167);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initializeUI(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(POO.class.getResource("scene.fxml"));
        Parent root = fxmlLoader.load();
        controller = fxmlLoader.getController();
        controller.stage = stage;
        Scene scene = new Scene(root, 214, 100);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Path Of Oil");
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    private void analyzeClipBoard(String data) {
        // Only do performant work when clipboard contains enchanted item
        // Not Null before data.contains to avoid NPE
        if (data == null || !data.contains("(enchant)")){
            return;
        }
        PoeItem item = new PoeItem(data);
        if (currentItem.equals(item)){
            return;
        }
        currentItem = item;
        Platform.runLater(controller::updatePictures);
    }



}
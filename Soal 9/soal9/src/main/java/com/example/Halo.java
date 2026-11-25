package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Halo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("tampilan.fxml"));
        stage.setScene(new Scene(root, 300, 150));
        stage.setTitle("Soal 9 - Halo JavaFX");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
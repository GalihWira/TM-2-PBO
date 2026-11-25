package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FormPeserta extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("form.fxml"));
        stage.setScene(new Scene(root, 400, 180));
        stage.setTitle("Soal 10 - Pendaftaran Seminar");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
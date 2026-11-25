package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HaloController {
    @FXML
    private Label lblPesan;

    @FXML
    private void klikSapa() {
        lblPesan.setText("Halo, JavaFX!");
    }
}
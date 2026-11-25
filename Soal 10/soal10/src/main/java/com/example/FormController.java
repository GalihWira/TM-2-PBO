package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FormController {
    @FXML
    private TextField txtNama;

    @FXML
    private Label lblStatus;

    @FXML
    private void klikSimpan() {
        String nama = txtNama.getText().trim();
        if (nama.isEmpty()) {
            lblStatus.setText("Nama tidak boleh kosong!");
            return;
        }

        String sql = "INSERT INTO peserta_seminar (nama) VALUES (?)";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nama);
            ps.executeUpdate();
            lblStatus.setText("Data " + nama + " berhasil disimpan.");
            txtNama.clear();
        } catch (SQLException e) {
            lblStatus.setText("Gagal menyimpan: " + e.getMessage());
        }
    }
}
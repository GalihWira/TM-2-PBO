import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KrsUpdateDeleteDAO {

    public void updateNilai(String nim, String kodeMk, String nilai) throws SQLException {
        String sql = "UPDATE krs SET nilai = ? WHERE nim = ? AND kode_mk = ?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nilai);
            ps.setString(2, nim);
            ps.setString(3, kodeMk);
            ps.executeUpdate();
        }
    }

    public void dropMataKuliah(String nim, String kodeMk) throws SQLException {
        String sql = "DELETE FROM krs WHERE nim = ? AND kode_mk = ?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nim);
            ps.setString(2, kodeMk);
            ps.executeUpdate();
        }
    }

    public void hapusMahasiswa(String nim) throws SQLException {
        String sql = "DELETE FROM mahasiswa WHERE nim = ?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nim);
            ps.executeUpdate();
        }
    }

    public void hapusMataKuliah(String kodeMk) throws SQLException {
        String sql = "DELETE FROM mata_kuliah WHERE kode_mk = ?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kodeMk);
            ps.executeUpdate();
        }
    }

    public void tampilkanKrs() throws SQLException {
        String sql = "SELECT m.nama, mk.nama_mk, k.nilai "
                   + "FROM krs k "
                   + "JOIN mahasiswa m ON k.nim = m.nim "
                   + "JOIN mata_kuliah mk ON k.kode_mk = mk.kode_mk "
                   + "ORDER BY k.nim, k.kode_mk";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nilai = rs.getString("nilai");
                if (nilai == null) {
                    nilai = "-";
                }
                System.out.println("  " + rs.getString("nama") + " | "
                        + rs.getString("nama_mk") + " | nilai: " + nilai);
            }
        }
    }
}
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KrsDAO {

    public void tambahMahasiswa(Mahasiswa m) throws SQLException {
        String sql = "INSERT INTO mahasiswa (nim, nama, angkatan) VALUES (?, ?, ?)";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, m.getNim());
            ps.setString(2, m.getNama());
            ps.setInt(3, m.getAngkatan());
            ps.executeUpdate();
        }
    }

    public void tambahMataKuliah(MataKuliah mk) throws SQLException {
        String sql = "INSERT INTO mata_kuliah (kode_mk, nama_mk, sks) VALUES (?, ?, ?)";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, mk.getKodeMk());
            ps.setString(2, mk.getNamaMk());
            ps.setInt(3, mk.getSks());
            ps.executeUpdate();
        }
    }

    public void tambahKrs(String nim, String kodeMk, String semester) throws SQLException {
        String sql = "INSERT INTO krs (nim, kode_mk, semester) VALUES (?, ?, ?)";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nim);
            ps.setString(2, kodeMk);
            ps.setString(3, semester);
            ps.executeUpdate();
        }
    }

    public void tampilkanKrs(String nim) throws SQLException {
        String sql = "SELECT m.nama, mk.kode_mk, mk.nama_mk, mk.sks "
                   + "FROM krs k "
                   + "JOIN mahasiswa m ON k.nim = m.nim "
                   + "JOIN mata_kuliah mk ON k.kode_mk = mk.kode_mk "
                   + "WHERE k.nim = ?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nim);
            ResultSet rs = ps.executeQuery();
            System.out.println("Daftar KRS mahasiswa " + nim + ":");
            while (rs.next()) {
                System.out.println("  " + rs.getString("kode_mk") + " - "
                        + rs.getString("nama_mk") + " (" + rs.getInt("sks") + " SKS)");
            }
        }
    }
}
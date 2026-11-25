import java.sql.SQLException;

public class MainSoal6 {
    public static void main(String[] args) {
        KrsDAO dao = new KrsDAO();

        try {
            dao.tambahMahasiswa(new Mahasiswa("2408561010", "I Wayan Darma Putra", 2024));
            System.out.println("Mahasiswa berhasil ditambahkan.");

            dao.tambahMataKuliah(new MataKuliah("IF2104", "Jaringan Komputer", 3));
            System.out.println("Mata kuliah berhasil ditambahkan.");

            dao.tambahKrs("2408561010", "IF2101", "Ganjil 2026/2027");
            dao.tambahKrs("2408561010", "IF2102", "Ganjil 2026/2027");
            dao.tambahKrs("2408561010", "IF2104", "Ganjil 2026/2027");
            System.out.println("Data KRS berhasil ditambahkan.\n");

            dao.tampilkanKrs("2408561010");
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan database: " + e.getMessage());
        }

        System.out.println("\nCoba tambah KRS dengan kode MK yang tidak ada (IF9999)...");
        try {
            dao.tambahKrs("2408561010", "IF9999", "Ganjil 2026/2027");
        } catch (SQLException e) {
            System.out.println("Gagal: " + e.getMessage());
        }
    }
}
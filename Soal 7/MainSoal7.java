import java.sql.SQLException;

public class MainSoal7 {
    public static void main(String[] args) {
        KrsUpdateDeleteDAO dao = new KrsUpdateDeleteDAO();

        try {
            System.out.println("Isi KRS awal:");
            dao.tampilkanKrs();

            dao.updateNilai("2408561001", "IF2101", "A");
            System.out.println("\nSetelah UPDATE nilai Komang Ayu di IF2101:");
            dao.tampilkanKrs();

            dao.dropMataKuliah("2408561001", "IF2102");
            System.out.println("\nSetelah Komang Ayu drop IF2102:");
            dao.tampilkanKrs();

            dao.hapusMahasiswa("2408561003");
            System.out.println("\nSetelah mahasiswa 2408561003 dihapus (KRS-nya ikut terhapus):");
            dao.tampilkanKrs();
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan database: " + e.getMessage());
        }

        System.out.println("\nCoba hapus mata kuliah IF2101 yang masih dipakai di KRS...");
        try {
            dao.hapusMataKuliah("IF2101");
        } catch (SQLException e) {
            System.out.println("Gagal: " + e.getMessage());
        }
    }
}
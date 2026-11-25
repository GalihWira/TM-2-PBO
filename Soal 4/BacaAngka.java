import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BacaAngka {

    public static void main(String[] args) {
        String namaFile = (args.length > 0) ? args[0] : "angka.txt";
        List<Integer> daftarNilai = new ArrayList<>();
        int barisSalah = 0;

        System.out.println("Membaca file: " + namaFile);

        try (BufferedReader br = new BufferedReader(new FileReader(namaFile))) {
            String baris;
            int noBaris = 0;
            while ((baris = br.readLine()) != null) {
                noBaris++;
                baris = baris.trim();
                if (baris.isEmpty()) continue;

                try {
                    int nilai = Integer.parseInt(baris);
                    daftarNilai.add(nilai);
                } catch (NumberFormatException e) {
                    barisSalah++;
                    System.out.println("  [!] Baris " + noBaris + " dilewati, bukan angka: \"" + baris + "\"");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Gagal: file \"" + namaFile + "\" tidak ditemukan.");
            System.out.println("Pastikan file ada di folder yang sama dengan program.");
            return;
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
            return;
        }

        int total = 0;
        for (int n : daftarNilai) total += n;

        System.out.println("Angka valid   : " + daftarNilai);
        System.out.println("Baris invalid : " + barisSalah);
        System.out.println("Jumlah        : " + total);
        if (!daftarNilai.isEmpty()) {
            System.out.printf("Rata-rata     : %.2f%n", (double) total / daftarNilai.size());
        }
    }
}
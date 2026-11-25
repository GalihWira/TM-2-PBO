import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContohCollection {
    public static void main(String[] args) {
        String[] klik = {"PBO", "Basis Data", "PBO", "Struktur Data", "Basis Data"};

        List<String> riwayatKlik = new ArrayList<>();
        Set<String> mkUnik = new HashSet<>();

        for (String mk : klik) {
            riwayatKlik.add(mk);
            mkUnik.add(mk);
        }

        System.out.println("ArrayList (" + riwayatKlik.size() + " data): " + riwayatKlik);
        System.out.println("HashSet   (" + mkUnik.size() + " data): " + mkUnik);

        System.out.println("Klik ke-2 : " + riwayatKlik.get(1));
        System.out.println("Ada 'PBO' di set? " + mkUnik.contains("PBO"));
        System.out.println("Tambah 'PBO' lagi berhasil? " + mkUnik.add("PBO"));
    }
}
import java.util.ArrayList;
import java.util.List;

class Antrian<T> {
    private final List<T> isi = new ArrayList<>();

    public void masuk(T data) {
        isi.add(data);
    }

    public T keluar() {
        if (isi.isEmpty())
            return null;
        return isi.remove(0);
    }

    public int jumlah() {
        return isi.size();
    }
}

public class ContohGeneric {

    public static <T extends Comparable<T>> T cariTerbesar(List<T> data) {
        T maks = data.get(0);
        for (T x : data) {
            if (x.compareTo(maks) > 0)
                maks = x;
        }
        return maks;
    }

    public static void main(String[] args) {

        Antrian<String> antriKrs = new Antrian<>();
        antriKrs.masuk("2508561001");
        antriKrs.masuk("2508561002");
        String nimPertama = antriKrs.keluar();
        System.out.println("Dilayani duluan : " + nimPertama);
        System.out.println("Sisa antrian    : " + antriKrs.jumlah());

        Antrian<Integer> nomorKursi = new Antrian<>();
        nomorKursi.masuk(12);
        nomorKursi.masuk(7);
        int kursi = nomorKursi.keluar();
        System.out.println("Kursi pertama   : " + kursi);

        List<Integer> nilaiKuis = List.of(78, 92, 85, 66);
        List<String> namaMk = List.of("Basis Data", "PBO", "Struktur Data");
        System.out.println("Nilai kuis tertinggi : " + cariTerbesar(nilaiKuis));
        System.out.println("Nama MK paling akhir : " + cariTerbesar(namaMk));
    }
}
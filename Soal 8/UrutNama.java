import java.util.ArrayList;
import java.util.List;

public class UrutNama {
    public static void main(String[] args) {
        List<String> namaMahasiswa = new ArrayList<>();
        namaMahasiswa.add("Wayan");
        namaMahasiswa.add("Komang");
        namaMahasiswa.add("Ketut");
        namaMahasiswa.add("Ayu");
        namaMahasiswa.add("Gede");
        namaMahasiswa.add("Made");
        namaMahasiswa.add("Putu");

        System.out.println("Sebelum diurutkan: " + namaMahasiswa);

        namaMahasiswa.sort((a, b) -> a.compareTo(b));
        System.out.println("Urut A-Z: " + namaMahasiswa);

        namaMahasiswa.sort((a, b) -> b.compareTo(a));
        System.out.println("Urut Z-A: " + namaMahasiswa);

        System.out.println("\nDaftar nama:");
        namaMahasiswa.forEach(nama -> System.out.println("- " + nama));
    }
}
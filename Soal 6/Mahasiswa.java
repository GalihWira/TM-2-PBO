public class Mahasiswa {
    private final String nim;
    private final String nama;
    private final int angkatan;

    public Mahasiswa(String nim, String nama, int angkatan) {
        this.nim = nim;
        this.nama = nama;
        this.angkatan = angkatan;
    }

    public String getNim() { return nim; }
    public String getNama() { return nama; }
    public int getAngkatan() { return angkatan; }
}
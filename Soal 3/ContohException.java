public class ContohException {

    static int rataSks(int totalSks, int jumlahSemester) {
        return totalSks / jumlahSemester;
    }

    public static void main(String[] args) {
        int[] sksPerSemester = {20, 22, 24};

        try {
            System.out.println("Rata-rata SKS: " + rataSks(66, 3));
            System.out.println("Rata-rata SKS: " + rataSks(66, 0));
            System.out.println("Baris ini tidak akan tercetak");
        } catch (ArithmeticException e) {
            System.out.println("Error: jumlah semester tidak boleh 0 (" + e.getMessage() + ")");
        } finally {
            System.out.println("[finally] perhitungan rata-rata selesai\n");
        }

        try {
            System.out.println("SKS semester 1: " + sksPerSemester[0]);
            System.out.println("SKS semester 4: " + sksPerSemester[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: data semester ke-4 belum ada");
        } catch (Exception e) {
            System.out.println("Error lain: " + e);
        } finally {
            System.out.println("[finally] pengecekan data SKS selesai\n");
        }

        String inputSks = "dua puluh";
        try {
            int sks = Integer.parseInt(inputSks);
            System.out.println("SKS: " + sks);
        } catch (NumberFormatException e) {
            System.out.println("Error: \"" + inputSks + "\" bukan angka");
        } finally {
            System.out.println("[finally] program tetap jalan sampai akhir");
        }
    }
}
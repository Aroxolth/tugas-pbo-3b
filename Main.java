import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU BENTUK ===");
            System.out.println("1. Demo Exercise 1 (Bujursangkar)");
            System.out.println("2. Demo Exercise 2 (Lingkaran)");
            System.out.println("3. Demo Exercise 3 (Silinder)");
            System.out.println("4. Demo Polymorphism (array Bentuk)");
            System.out.println("5. Buat bentuk sendiri (input pengguna)");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            input.nextLine(); // buang sisa newline

            switch (pilihan) {
                case 1: demoBujurSangkar(); break;
                case 2: demoLingkaran(); break;
                case 3: demoSilinder(); break;
                case 4: demoPolymorphism(); break;
                case 5: buatSendiri(input); break;
                case 0: System.out.println("Terima kasih!"); break;
                default: System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        input.close();
    }

    static void demoBujurSangkar() {
        System.out.println("\n--- Exercise 1 ---");
        Bentuk b = new Bentuk("Hijau");
        b.printInfo();

        BujurSangkar bs = new BujurSangkar(5, "Merah");
        bs.printInfo();
        System.out.println("Sisi  : " + bs.getSisi());
        bs.setSisi(8);
        bs.setWarna("Biru");
        System.out.println("Setelah setSisi(8) dan setWarna(Biru):");
        bs.printInfo();
    }

    static void demoLingkaran() {
        System.out.println("\n--- Exercise 2 ---");
        Lingkaran l = new Lingkaran(7, "Kuning");
        l.printInfo();
        System.out.println("Radius: " + l.getRadius());
        l.setRadius(10);
        System.out.println("Setelah setRadius(10):");
        l.printInfo();
    }

    static void demoSilinder() {
        System.out.println("\n--- Exercise 3 ---");
        Silinder s = new Silinder(10, 7, "Hitam");
        s.printInfo();
        System.out.println("Tinggi: " + s.getTinggi());
        System.out.println("Radius: " + s.getRadius());
        System.out.println("Luas alas: " + s.hitungLuas());
        s.setTinggi(20);
        System.out.println("Setelah setTinggi(20):");
        s.printInfo();
    }

    static void demoPolymorphism() {
        System.out.println("\n--- Polymorphism ---");
        // Semua objek disimpan sebagai tipe Bentuk, tapi printInfo() yang
        // dipanggil mengikuti tipe objek aslinya (dynamic binding).
        Bentuk[] daftar = {
            new Bentuk("Putih"),
            new BujurSangkar(4, "Merah"),
            new Lingkaran(3, "Biru"),
            new Silinder(5, 3, "Hijau")
        };
        for (Bentuk b : daftar) {
            b.printInfo();
        }
    }

    static void buatSendiri(Scanner input) {
        System.out.println("\nPilih bentuk: 1) Bujursangkar  2) Lingkaran  3) Silinder");
        System.out.print("Pilih: ");
        int jenis = input.nextInt();
        input.nextLine();

        System.out.print("Warna: ");
        String warna = input.nextLine();

        Bentuk bentuk;
        if (jenis == 1) {
            System.out.print("Sisi: ");
            bentuk = new BujurSangkar(input.nextDouble(), warna);
        } else if (jenis == 2) {
            System.out.print("Radius: ");
            bentuk = new Lingkaran(input.nextDouble(), warna);
        } else if (jenis == 3) {
            System.out.print("Radius: ");
            double r = input.nextDouble();
            System.out.print("Tinggi: ");
            double t = input.nextDouble();
            bentuk = new Silinder(t, r, warna);
        } else {
            System.out.println("Jenis tidak valid.");
            return;
        }
        input.nextLine();
        bentuk.printInfo();
    }
}

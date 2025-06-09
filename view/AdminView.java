package view;

import java.util.Scanner;

public class AdminView {
    private Scanner scanner;

    public AdminView() {
        this.scanner = new Scanner(System.in);
    }

    // Menampilkan menu utama untuk admin
    public void showAdminMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Lihat Riwayat Absensi");
            System.out.println("2. Kelola Pengguna");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1/2/3): ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    showAbsensiData();
                    break;
                case "2":
                    manageUsers();
                    break;
                case "3":
                    running = false;
                    System.out.println("Keluar dari sistem.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }

    // Menampilkan data riwayat absensi
    private void showAbsensiData() {
        System.out.println("\n=== Riwayat Absensi ===");
        // Menampilkan data absensi 
        System.out.println("1. NIM: 12345, Status: Hadir, Tanggal: 2023-06-10");
        System.out.println("2. NIM: 67890, Status: Izin, Tanggal: 2023-06-10");
        System.out.println("... (Data lainnya)");

        System.out.print("Tekan enter untuk kembali ke menu admin.");
        scanner.nextLine();  // Tunggu input enter untuk kembali ke menu
    }

    private void manageUsers() {
        System.out.println("\n=== Kelola Pengguna ===");
        System.out.println("1. Tambah Pengguna");
        System.out.println("2. Hapus Pengguna");
        System.out.println("3. Kembali ke Menu Admin");
        System.out.print("Pilih opsi (1/2/3): ");
        String pilihan = scanner.nextLine();

        switch (pilihan) {
            case "1":
                addUser();
                break;
            case "2":
                removeUser();
                break;
            case "3":
                return;  // back ke menu admin
            default:
                System.out.println("Pilihan tidak valid. Kembali ke menu.");
        }
    }

    // add pengguna baru
    private void addUser() {
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();

        // Panggil controller
        System.out.println("Pengguna dengan NIM " + nim + " dan nama " + nama + " telah ditambahkan.");
    }

    // Menghapus user
    private void removeUser() {
        System.out.print("Masukkan NIM pengguna yang akan dihapus: ");
        String nim = scanner.nextLine();

        // Panggil controller 
        System.out.println("Pengguna dengan NIM " + nim + " telah dihapus.");
    }
}

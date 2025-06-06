package view.admin;

import controller.AdminController;
import model.User;
import view.AdminView;

import java.util.List;

public class AdminKaryawanView extends AdminView {
    private final AdminController adminController;

    public AdminKaryawanView(User user, java.util.Scanner scanner) {
        super(user, scanner);
        this.adminController = new AdminController();
    }

    public void showKaryawanMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Menu Kelola Karyawan ===");
            System.out.println("1. Lihat Semua Karyawan");
            System.out.println("2. Tambah Karyawan");
            System.out.println("3. Edit Karyawan");
            System.out.println("4. Hapus Karyawan");
            System.out.println("5. Cari Karyawan");
            System.out.println("6. Kembali");
            System.out.print("Pilih menu (1-6): ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    showAllKaryawan();
                    break;
                case "2":
                    tambahKaryawan();
                    break;
                case "3":
                    editKaryawan();
                    break;
                case "4":
                    hapusKaryawan();
                    break;
                case "5":
                    cariKaryawan();
                    break;
                case "6":
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void showAllKaryawan() {
        int page = 1;
        final int pageSize = 5;
        while (true) {
            List<User> users = adminController.getAllKaryawan(page, pageSize);
            if (users.isEmpty()) {
                System.out.println("Tidak ada data karyawan.");
                return;
            }

            System.out.println("\n--- Data Karyawan (Halaman " + page + ") ---");
            for (User u : users) {
                System.out.printf("ID: %d | NIM: %s | Nama: %s | Role: %s\n", u.getId(), u.getNim(), u.getName(), u.getRole());
            }

            System.out.print("\n[N]ext, [P]revious, [E]xit: ");
            String action = scanner.nextLine().toLowerCase();
            if (action.equals("n")) page++;
            else if (action.equals("p") && page > 1) page--;
            else break;
        }
    }

    private void tambahKaryawan() {
        System.out.print("Masukkan Nama: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine();

        boolean success = adminController.insertKaryawan(name, nim, password);
        if (success) {
            System.out.println("Karyawan berhasil ditambahkan.");
        } else {
            System.out.println("Gagal menambahkan karyawan.");
        }
    }

    private void editKaryawan() {
        System.out.print("Masukkan NIM karyawan yang ingin diedit: ");
        String nim = scanner.nextLine();

        User user = adminController.getKaryawanByNim(nim);
        if (user == null) {
            System.out.println("Karyawan tidak ditemukan.");
            return;
        }

        System.out.print("Nama baru (" + user.getName() + "): ");
        String newName = scanner.nextLine();
        System.out.print("Password baru (biarkan kosong jika tidak diubah): ");
        String newPassword = scanner.nextLine();

        boolean success = adminController.updateKaryawan(user.getId(), newName.isEmpty() ? user.getName() : newName, newPassword);
        if (success) {
            System.out.println("Data karyawan berhasil diupdate.");
        } else {
            System.out.println("Gagal mengupdate data karyawan.");
        }
    }

    private void hapusKaryawan() {
        System.out.print("Masukkan NIM karyawan yang ingin dihapus: ");
        String nim = scanner.nextLine();

        boolean success = adminController.deleteKaryawanByNim(nim);
        if (success) {
            System.out.println("Karyawan berhasil dihapus.");
        } else {
            System.out.println("Gagal menghapus karyawan.");
        }
    }

    private void cariKaryawan() {
        System.out.print("Masukkan keyword (nama atau NIM): ");
        String keyword = scanner.nextLine();

        List<User> results = adminController.searchKaryawan(keyword);
        if (results.isEmpty()) {
            System.out.println("Tidak ada hasil ditemukan.");
        } else {
            for (User u : results) {
                System.out.printf("ID: %d | NIM: %s | Nama: %s | Role: %s\n", u.getId(), u.getNim(), u.getName(), u.getRole());
            }
        }
    }
}

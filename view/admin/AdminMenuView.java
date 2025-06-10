package view.admin;

import model.User;
import view.AdminView;

public class AdminMenuView extends AdminView {
    private final AdminAbsensiView absensiView;
    private final AdminKaryawanView karyawanView;

    public AdminMenuView(User user) {
        super(user);
        this.absensiView = new AdminAbsensiView(user);
        this.karyawanView = new AdminKaryawanView(user);
    }

    public void showMenu() {
        boolean adminMenu = true;
        while (adminMenu) {
            System.out.println("\n=== Halaman Utama Admin ===");
            System.out.println("Selamat datang, " + user.getName() + " (" + user.getRole() + ")");
            System.out.println("1. Kelola Karyawan");
            System.out.println("2. Kelola Absensi");
            System.out.println("3. Logout");
            System.out.print("Pilih menu (1/2/3): ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    karyawanView.showKaryawanMenu();
                    break;
                case "2":
                    absensiView.showAbsensiMenu();
                    break;
                case "3":
                    System.out.println("Logout dari menu admin.");
                    adminMenu = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}

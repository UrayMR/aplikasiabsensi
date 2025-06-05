package view.absen;

import view.AbsenView;

public class AbsenMenuView extends AbsenView {
    private final AbsenFormView absenFormView = new AbsenFormView();

    public AbsenMenuView() {
        super();
    }

    public void showMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Halaman Utama Absensi ===");
            System.out.println("1. Absen kehadiran");
            System.out.println("2. Keluar");
            System.out.print("Pilih menu (1/2): ");
            String pilihan = scanner.nextLine();
            switch (pilihan) {
                case "1":
                    absenFormView.showAbsensiForm();
                    break;
                case "2":
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}

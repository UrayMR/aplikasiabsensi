package view;

import java.util.Scanner;

public class AbsenView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
      boolean absenMenu = true;
      while (absenMenu) {
          System.out.println("\n=== Halaman Absensi ===");
          System.out.println("1. Kembali ke Menu Utama");
          System.out.print("Pilih menu (1): ");
          String choice = scanner.nextLine();
          switch (choice) {
              case "1":
                  absenMenu = false;
                  break;
              default:
                  System.out.println("Pilihan tidak valid.");
          }
      }
    }
}

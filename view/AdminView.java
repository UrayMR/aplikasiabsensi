package view;

import java.util.Scanner;
import model.User;

public class AdminView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu(User user) {
        boolean adminMenu = true;
        while (adminMenu) {
            System.out.println("\n=== Halaman Utama Admin ===");
            System.out.println("Selamat datang, " + user.getName() + " (Admin)");
            System.out.println("1. Logout");
            System.out.print("Pilih menu (1): ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Logout dari menu admin.");
                    adminMenu = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}

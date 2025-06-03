package app;

import java.util.Scanner;
import model.User;
import model.Guest;
import view.AuthView;
import config.EnvLoader;

public class Main {
    public static void main(String[] args) {
        EnvLoader.loadEnv();
        AuthView authView = new AuthView();
        User user = null;
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        try {
            while (running) {
                System.out.println("\n==========");
                System.out.println("\nMENU UTAMA");
                System.out.println("\n==========");
                System.out.println("1. Login Admin");
                System.out.println("2. Absensi Karyawan");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu (1/2/3): ");

                String menu = scanner.nextLine();

                if (menu.equals("1")) {
                    user = authView.loginPage();
                    if (user != null && user.getRole().equals("admin")) {
                        user.showMenu();
                    } else {
                        System.out.println("Login gagal atau anda bukan admin.");
                    }
                }
                
                if (menu.equals("2")) {
                    user = new Guest();
                    user.showMenu();
                    continue;
                }
                if (menu.equals("3")) {
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    running = false;
                    continue;
                }
            }
        } finally {
            scanner.close();
        }
    }
}

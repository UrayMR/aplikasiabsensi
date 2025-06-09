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
                System.out.println("3. Register Karyawan");
                System.out.println("4. Keluar");
                System.out.print("Pilih menu (1/2/3/4): ");

                String menu = scanner.nextLine();

                switch (menu) {
                    case "1":
                        user = authView.loginPage();
                        if (user != null && user.getRole().equals("admin")) {
                            user.showMenu();
                        } else {
                            System.out.println("Login gagal atau anda bukan admin.");
                        }
                        break;
                    case "2":
                        user = new Guest();
                        user.showMenu();
                        break;
                    case "3":
                        authView.registerPage();
                        break;
                    case "4":
                        System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                        running = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            }
        } finally {
            scanner.close();
        }
    }
}

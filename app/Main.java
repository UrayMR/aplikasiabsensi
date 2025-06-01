package app;

import java.util.Scanner;
import model.User;
import view.AuthView;
import config.EnvLoader;

public class Main {
    public static void main(String[] args) {
        EnvLoader.loadEnv();
        AuthView authView = new AuthView();
        User user;
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        try {
            while (running) {
                user = null;

                System.out.println("\n===== MENU UTAMA =====");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu (1/2/3): ");
                String menu = scanner.nextLine();
                if (menu.equals("2")) {
                    authView.showRegister();
                    continue; // Kembali ke menu utama setelah register
                }
                
                if (menu.equals("3")) {
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    running = false;
                    continue; // Keluar dari loop utama
                }

                // Login loop
                do {
                    user = authView.loginPage();
                } while (user == null);

                // Menu loop
                boolean loggedIn = true;
                while (loggedIn) {
                    switch (user.getRole()) {
                        case "admin":
                            System.out.println("Menu Admin akan ditampilkan...");
                            break;
                        case "pengajar":
                            System.out.println("Menu Pengajar akan ditampilkan...");
                            break;
                        case "peserta":
                            System.out.println("Menu Peserta akan ditampilkan...");
                            break;
                        default:
                            System.out.println("Role tidak dikenal.");
                    }

                    System.out.println("Selamat datang, " + user.getName() + " (" + user.getRole() + ")");
                    
                    // Logout 
                    System.out.println("Ketik 'logout' untuk keluar, ENTER untuk lanjut...");
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("logout")) {
                        authView.showLogout();
                        loggedIn = false;
                    }
                }
            }
        } finally {
            scanner.close();
        }
    }
}

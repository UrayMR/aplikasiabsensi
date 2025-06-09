package view;

import controller.AuthController;
import model.User;
import java.util.Scanner;

public class AuthView {
    private final AuthController authController;
    private final Scanner scanner;

    public AuthView() {
        this.authController = new AuthController();
        this.scanner = new Scanner(System.in);
    }

    public User loginPage() {
        System.out.println("\n==========");
        System.out.println("\nLOGIN");
        System.out.println("\n==========");
        System.out.print("NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = authController.login(nim, password);
        if (user != null) {
            System.out.println("Login berhasil!");
            return user;
        } else {
            System.out.println("Login gagal. nim atau password salah.");
            return null;
        }
    }

    public void registerPage() {
        System.out.println("\n==========");
        System.out.println("\nREGISTER KARYAWAN");
        System.out.println("\n==========");
        System.out.print("NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Nama: ");
        String name = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        boolean success = authController.register(name, nim, password);
        if (success) {
            System.out.println("Registrasi berhasil! Silahkan lakukan absensi.");
        } else {
            System.out.println("Registrasi gagal. NIM mungkin sudah terdaftar.");
        }
    }

    public void showLogout() {
        authController.logout();
        System.out.println("Anda telah logout.");
    }
}

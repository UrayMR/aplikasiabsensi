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
        System.out.println("\n===== LOGIN =====");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = authController.login(email, password);
        if (user != null) {
            System.out.println("Login berhasil!");
            return user;
        } else {
            System.out.println("Login gagal. Email atau password salah.");
            return null;
        }
    }

    public void showRegister() {
        System.out.println("\n===== REGISTER =====");
        System.out.print("Nama: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        // System.out.print("Role (admin/pengajar/peserta): ");
        // String role = scanner.nextLine();
        String role = "peserta";

        boolean success = authController.register(name, email, password, role);
        if (success) {
            System.out.println("Registrasi berhasil!");
        } else {
            System.out.println("Registrasi gagal.");
        }
    }

    public void showLogout() {
        authController.logout();
        System.out.println("Anda telah logout.");
    }
}

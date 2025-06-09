package view.absen;

import java.util.Scanner;

public abstract class AbsenView {

    // Scanner untuk membaca input pengguna
    protected Scanner scanner;

    // Konstruktor untuk menginisialisasi scanner
    public AbsenView() {
        this.scanner = new Scanner(System.in);
    }

    // Metode pembantu untuk menampilkan informasi umum atau error
    protected void printMessage(String message) {
        System.out.println(message);
    }

    // Metode pembantu untuk meminta input string
    protected String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Metode pembantu untuk menutup scanner
    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}

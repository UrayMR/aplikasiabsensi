package view.absen;

import java.util.Scanner;

public abstract class AbsenView {

    protected Scanner scanner;

    // Konstruktor
    public AbsenView() {
        this.scanner = new Scanner(System.in);
    }

    protected void printMessage(String message) {
        System.out.println(message);
    }

    protected String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}

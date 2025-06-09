package view;

import java.util.Scanner;

public abstract class AbsenView {
    protected final Scanner scanner;

    public AbsenView() {
        this.scanner = new Scanner(System.in);
    }
}
package view;

import java.util.Scanner;
import model.User;

public abstract class AdminView {
    protected final Scanner scanner;
    protected final User user;

    public AdminView(User user, Scanner scanner) {
        this.user = user;
        this.scanner = scanner;
    }
}
package model;

import view.admin.AdminMenuView;

public class Admin extends User {
    public Admin(int id, String nim, String name, String password) {
        super(id, nim, name, password, "admin");
    }

    @Override
    public void showMenu() {
        AdminMenuView adminView = new AdminMenuView(this);
        adminView.showMenu();
    }
}

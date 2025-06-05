package model;

import view.admin.AdminMenuView;

public class Admin extends User {
    public Admin(int id, String name, String nim) {
        super(id, name, "admin", nim);
    }

    @Override
    public void showMenu() {
        AdminMenuView adminView = new AdminMenuView(this);
        adminView.showMenu();
    }
}

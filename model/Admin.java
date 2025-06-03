package model;

public class Admin extends User {
    public Admin(int id, String name, String nim) {
        super(id, name, "admin", "0");
    }

    // Tambahkan method khusus admin jika diperlukan
    @Override
    public void showMenu() {
        view.AdminView adminView = new view.AdminView();
        adminView.showMenu(this);
    }
}

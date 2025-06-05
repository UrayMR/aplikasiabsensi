package model;

import view.absen.AbsenMenuView;

public class Guest extends User {
    public Guest() {
        super();
    }

    @Override
    public void showMenu() {
        AbsenMenuView absenView = new AbsenMenuView();
        absenView.showMenu();
    }
}

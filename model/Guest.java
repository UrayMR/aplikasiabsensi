package model;

import view.AbsenView;

public class Guest extends User {
    public Guest() {
        super();
    }

    @Override
    public void showMenu() {
        AbsenView absenView = new AbsenView();
        absenView.showMenu();
    }
}

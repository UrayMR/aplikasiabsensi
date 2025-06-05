package controller;

import dao.AdminDAO;
import model.Absensi;
import java.util.List;

public class AdminController {
    private final AdminDAO adminDAO;

    public AdminController() {
        this.adminDAO = new AdminDAO();
    }

    public List<Absensi> getAllAbsensi() {
        return adminDAO.getAllAbsensi();
    }

    public List<Absensi> getLastAbsensiLog() {
        return adminDAO.getLastAbsensiLog();
    }

    public List<Absensi> searchAbsensi(String keyword) {
        return adminDAO.searchAbsensi(keyword);
    }
}

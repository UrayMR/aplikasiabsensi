package controller;

import dao.AdminDAO;
import dao.UserDAO;
import model.Absensi;
import model.User;

import java.util.List;

public class AdminController {
    private final AdminDAO adminDAO;
    private final UserDAO userDAO;

    public AdminController() {
        this.adminDAO = new AdminDAO();
        this.userDAO = new UserDAO();
    }

    // ===== Absensi Related =====
    public List<Absensi> getAllAbsensi() {
        return adminDAO.getAllAbsensi();
    }

    public List<Absensi> getAllAbsensi(int page, int pageSize) {
        return adminDAO.getAllAbsensi(page, pageSize);
    }

    public List<Absensi> getLastAbsensiLog() {
        return adminDAO.getLastAbsensiLog();
    }

    public List<Absensi> searchAbsensi(String keyword) {
        return adminDAO.searchAbsensi(keyword);
    }

    // ===== Karyawan Related =====
    public List<User> getAllKaryawan(int page, int pageSize) {
        return userDAO.getAllKaryawan(page, pageSize);
    }

    public boolean insertKaryawan(String name, String nim, String password, String role) {
        return userDAO.insert(name, nim, password, role);
    }

    public User getKaryawanByNim(String nim) {
        return userDAO.getByNim(nim);
    }

    public boolean updateKaryawan(int id, String name, String password) {
        return userDAO.update(id, name, password);
    }

    public boolean deleteKaryawanByNim(String nim) {
        return userDAO.deleteByNim(nim);
    }

    public List<User> searchKaryawan(String keyword) {
        return userDAO.search(keyword);
    }
}


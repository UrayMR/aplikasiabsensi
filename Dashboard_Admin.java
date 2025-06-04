package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.AttendanceController;
import model.Attendance;
import java.util.List;

public class AdminDashboard extends JFrame {
    private AttendanceController attendanceController;
    
    public AdminDashboard() {
        attendanceController = new AttendanceController();
        initUI();
        loadLastAttendances();
    }
    
    private void initUI() {
        setTitle("Admin Dashboard - Manajemen Kehadiran");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        JLabel headerLabel = new JLabel("Manajemen Kehadiran Karyawan", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(headerLabel, BorderLayout.NORTH);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel lastAttendancePanel = new JPanel(new BorderLayout());
        JTextArea attendanceTextArea = new JTextArea();
        attendanceTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(attendanceTextArea);
        lastAttendancePanel.add(scrollPane, BorderLayout.CENTER);
        
        JPanel searchPanel = new JPanel();
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Cari");
        searchPanel.add(new JLabel("Cari (nama/status):"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = searchField.getText();
                List<Attendance> results = attendanceController.searchAttendances(keyword);
                displayAttendances(attendanceTextArea, results);
            }
        });
        
        lastAttendancePanel.add(searchPanel, BorderLayout.NORTH);
        tabbedPane.addTab("Log Absensi Terakhir", lastAttendancePanel);
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        add(mainPanel);
    }
    private void loadLastAttendances() {
    }
    
    private void displayAttendances(JTextArea textArea, List<Attendance> attendances) {
        StringBuilder sb = new StringBuilder();
        for (Attendance a : attendances) {
            sb.append(String.format("ID: %d, User ID: %d, Tanggal: %s, Status: %s\n", 
                a.getId(), a.getUserId(), a.getDate(), a.getStatus()));
        }
        textArea.setText(sb.toString());
    }
}
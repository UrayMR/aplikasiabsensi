package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import controller.AttendanceController;

public class AttendanceView extends JFrame {
    private int userId;
    private AttendanceController attendanceController;
    
    public AttendanceView(int userId) {
        this.userId = userId;
        this.attendanceController = new AttendanceController();
        initUI();
    }
    private void initUI() {
        setTitle("Absensi Karyawan");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        JLabel headerLabel = new JLabel("Form Absensi", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(headerLabel, BorderLayout.NORTH);
        JPanel formPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        JLabel dateLabel = new JLabel("Tanggal: " + currentDate);
        formPanel.add(dateLabel);
        JPanel statusPanel = new JPanel();
        ButtonGroup statusGroup = new ButtonGroup();
        JRadioButton presentRadio = new JRadioButton("Hadir", true);
        JRadioButton sickRadio = new JRadioButton("Sakit");
        JRadioButton leaveRadio = new JRadioButton("Izin");
        
        statusGroup.add(presentRadio);
        statusGroup.add(sickRadio);
        statusGroup.add(leaveRadio);
        
        statusPanel.add(new JLabel("Status:"));
        statusPanel.add(presentRadio);
        statusPanel.add(sickRadio);
        statusPanel.add(leaveRadio);
        formPanel.add(statusPanel);

        JButton submitButton = new JButton("Submit Absensi");
        formPanel.add(submitButton);
        
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String status = "hadir";
                if (sickRadio.isSelected()) status = "sakit";
                else if (leaveRadio.isSelected()) status = "izin";
                
                boolean success = attendanceController.recordAttendance(
                    userId, currentDate, status);
                if (success) {
                    JOptionPane.showMessageDialog(AttendanceView.this, 
                        "Absensi berhasil dicatat!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(AttendanceView.this, 
                        "Gagal mencatat absensi!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mainPanel.add(formPanel, BorderLayout.CENTER);
        add(mainPanel);
    }
}
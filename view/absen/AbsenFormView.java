package view.absen;

import controller.AbsensiController;
import view.AbsenView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AbsenFormView extends AbsenView{
  private final AbsensiController absensiController;

  public AbsenFormView() {
      super();
      this.absensiController = new AbsensiController();
  }

  public void showAbsensiForm() {
    String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    System.out.println("\n=== Form Absensi ===");
    System.out.println("Tanggal: " + currentDate);
    System.out.print("Masukkan NIM: ");
    String nim = scanner.nextLine();

    if (nim.isEmpty()) {
        System.out.println("NIM tidak boleh kosong!");
        return;
    }

    System.out.println("Pilih status absensi:");
    System.out.println("1. Hadir");
    System.out.println("2. Sakit");
    System.out.println("3. Izin");
    System.out.print("Masukkan pilihan (1/2/3): ");
    String statusPilihan = scanner.nextLine();

    String status;
    switch (statusPilihan) {
        case "1":
            status = "hadir";
            break;
        case "2":
            status = "sakit";
            break;
        case "3":
            status = "izin";
            break;
        default:
            System.out.println("Pilihan tidak valid. Absensi tidak dicatat.");
            return;
    }


    int userId = 0; // Diganti dengan fungsi getUserIdByNim dari AbsensiController
    if (userId == -1) {
        System.out.println("NIM tidak ditemukan!");
        return;
    }
    
    boolean success = false; // Diganti dengan fungsi insertAbsensi dari AbsensiController
    if (success) {
        System.out.println("Absensi berhasil dicatat!");
    } else {
        System.out.println("Gagal mencatat absensi!");
    }
}
}

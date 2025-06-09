package com.example.aplikasiabsensi.model;

public class Absensi {
    private String nim;
    private String jenisAbsen;

    // Constructor
    public Absensi(String nim, String jenisAbsen) {
        this.nim = nim;
        this.jenisAbsen = jenisAbsen;
    }

    // Getter and Setter
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getJenisAbsen() {
        return jenisAbsen;
    }

    public void setJenisAbsen(String jenisAbsen) {
        this.jenisAbsen = jenisAbsen;
    }
}

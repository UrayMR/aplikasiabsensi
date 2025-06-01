# Kursus Online Java Console App

Aplikasi kursus online berbasis Java console sederhana.

## Kebutuhan

- Java JDK 8 atau lebih baru
- MySQL Server (sudah berjalan dan database sudah dibuat)
- Library MySQL Connector/J (sudah ada di folder `lib/`)
- PowerShell (untuk Windows) atau Command Prompt

## Struktur Folder

```
├── app/
│   └── Main.java           # File utama aplikasi (package app)
├── config/
│   ├── conn.java           # Koneksi database
│   └── EnvLoader.java      # Loader file .env
├── controller/             # Logika program (AuthController, dst)
├── database/
│   └── db.sql              # Skema database MySQL
├── helper/                 # Fungsi bantuan (PasswordHelper, dst)
├── lib/                    # Library eksternal (Mysql.jar, dst)
├── model/                  # Model data (User, dst)
├── view/                   # Tampilan (AuthView, dst)
├── .env.example            # Contoh konfigurasi koneksi database
├── .gitignore              # File yang diabaikan git
├── build.bat               # Script build (Windows CMD/PowerShell)
├── run.bat                 # Script run (Windows CMD/PowerShell)
└── README.md               # Dokumentasi
```

## Konfigurasi Database

1. Buat database dan tabel sesuai `database/db.sql` di MySQL Anda.
2. Salin `.env.example` menjadi `.env` dan sesuaikan isinya:
   ```env
   DB_URL=jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_NAME}
   DB_HOST=localhost
   DB_NAME=kursusonline
   DB_PORT=3306
   DB_USER=root
   DB_PASSWORD=yourpassword
   ```

## Cara Build & Run

### PowerShell (Windows)

```powershell
# Build semua file Java
./build.ps1
# Jalankan aplikasi
./run.ps1
```

### Command Prompt (Windows)

```bat
build.bat
run.bat
```

### Manual (tanpa script)

```powershell
# Compile semua file Java di seluruh folder
$files = Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName }
javac -cp ".;lib/*" -d . $files
# Jalankan aplikasi
java -cp ".;lib/*" app.Main
```

## Catatan Penting

- Jangan push file `.env` ke repository publik.
- Pastikan file `mysql-connector-j-9.2.0.jar` ada di folder `lib/`.
- Jika ada perubahan kode, lakukan build ulang sebelum run.
- Script build/run tersedia untuk PowerShell (`.ps1`) dan CMD (`.bat`).

---

Selamat mencoba!

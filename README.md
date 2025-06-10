# Kursus Online Java Console App

Aplikasi kursus online berbasis Java console sederhana.

## Kebutuhan

- Java JDK 8 atau lebih baru
- MySQL Server (XAMPP, dsb) (sudah berjalan dan database sudah dibuat)
- Library MySQL Connector/J (sudah ada di folder `lib/`)
- PowerShell (untuk Windows) atau Command Prompt
- Git (untuk kolaborasi)

## Struktur Folder

```
├── app/
│   └── Main.java           # File utama aplikasi (package app)
├── config/
│   ├── conn.java           # Koneksi database
│   └── EnvLoader.java      # Loader file .env
├── controller/             # Logika program (AuthController, dst)
├── dao/                    # Query program (AuthDAO, dst)
├── database/
│   └── db.sql              # Skema database MySQL
├── helper/                 # Fungsi bantuan (PasswordHelper, dst)
├── lib/                    # Library eksternal (mysql.jar, dst)
├── model/                  # Model data (User, dst)
├── view/                   # Tampilan (AuthView, dst)
├── .env.example            # Contoh konfigurasi koneksi database
├── .gitignore              # File yang diabaikan git
├── build.bat               # Script build (Windows CMD/PowerShell)
├── run.bat1                # Script run (Windows CMD/PowerShell)
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
./build.ps1   # Build semua file Java
./run.ps1     # Jalankan aplikasi
```

### Command Prompt (Windows)

```bat
build.bat     @REM Build semua file Java
run.bat       @REM Jalankan aplikasi
```

### Manual (tanpa script)

```powershell
$files = Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName }
javac -cp ".;lib/*" -d . $files
java -cp ".;lib/*" app.Main
```

## Catatan Penting

- Jangan push file `.env` ke repository publik.
- Pastikan file `mysql-connector-j-9.2.0.jar` ada di folder `lib/`.
- Jika ada perubahan kode, lakukan build ulang sebelum run.
- Script build/run tersedia untuk PowerShell (`.ps1`) dan CMD (`.bat`).

---

## Cara Berkontribusi

1. **Clone** repository ini.
   ```powershell
   git clone https://github.com/UrayMR/kursusonline.git
   ```
2. **Buat branch baru** untuk setiap perubahan/fitur:
   ```powershell
   git checkout -b nama-branch-anda
   ```
3. Buat file .env apabila belum ada. Salin dari .env.example:
   ```powershell
   cp .env.example .env
   ```
4. **Build dan test** aplikasi secara lokal:
   ```powershell
   ./build.ps1
   ./run.ps1
   ```
5. **Commit** perubahan Anda:
   ```powershell
   git add .
   git commit -m "Deskripsi perubahan"
   ```
6. **Push** branch ke remote:
   ```powershell
   git push origin nama-branch-anda
   ```
7. Menunggu pemilik repo melakukan penggabungan ke branch main.
8. **Mengambil perubahan terbaru** dari branch main :
   ```powershell
   git pull origin main
   ```

---

Selamat mencoba dan berkontribusi!
Halooo everyonee

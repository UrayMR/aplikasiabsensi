const express = require('express');
const mysql = require('mysql2');
const bodyParser = require('body-parser');

const app = express();
const port = 3000;

app.use(bodyParser.urlencoded({ extended: true }));

// Membuat koneksi ke database
const db = mysql.createConnection({
  host: 'localhost',
  user: 'root', 
  password: '', 
  database: 'aplikasiabsensi', 
});

db.connect((err) => {
  if (err) throw err;
  console.log('Connected to database');
});

// Route untuk input absensi
app.post('/absen', (req, res) => {
  const { nim, jenis_absen } = req.body;

  const query = `INSERT INTO absensi (nim, jenis_absen) VALUES (?, ?)`;
  
  db.query(query, [nim, jenis_absen], (err, result) => {
    if (err) {
      console.error('Error inserting data:', err);
      res.send('Terjadi kesalahan saat absen.');
    } else {
      res.send('Absensi berhasil dilakukan!');
    }
  });
});

app.listen(port, () => {
  console.log(`Server berjalan di http://localhost:${port}`);
});

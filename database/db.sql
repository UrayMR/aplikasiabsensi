CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(100) NOT NULL UNIQUE,
  name VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  role ENUM('admin', 'pengajar', 'peserta') NOT NULL DEFAULT 'peserta'
);

-- CREATE TABLE kursus (
--   id INT AUTO_INCREMENT PRIMARY KEY,
--   nama VARCHAR(100) NOT NULL,
--   deskripsi TEXT,
--   harga DOUBLE,
--   pengajar_id INT,
--   FOREIGN KEY (pengajar_id) REFERENCES users(id)
-- );

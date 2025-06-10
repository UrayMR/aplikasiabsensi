-- Seeder untuk tabel users
INSERT INTO users (name, password, role, nim) VALUES
('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'admin', '23081010029'), -- password: admin
('budi', 'e10adc3949ba59abbe56e057f20f883e', 'karyawan', '23081010030'), -- password: 123456
('siti', '25d55ad283aa400af464c76d713c07ad', 'karyawan', '23081010031'), -- password: 12345678
('agus', 'e10adc3949ba59abbe56e057f20f883e', 'karyawan', '23081010032'), -- password: 123456
('dina', '25d55ad283aa400af464c76d713c07ad', 'karyawan', '23081010033'), -- password: 12345678
('rudi', 'e10adc3949ba59abbe56e057f20f883e', 'karyawan', '23081010034'), -- password: 123456
('lina', '25d55ad283aa400af464c76d713c07ad', 'karyawan', '23081010035'), -- password: 12345678
('yusuf', 'e10adc3949ba59abbe56e057f20f883e', 'karyawan', '23081010036'), -- password: 123456
('nina', '25d55ad283aa400af464c76d713c07ad', 'karyawan', '23081010037'), -- password: 12345678
('andi', 'e10adc3949ba59abbe56e057f20f883e', 'karyawan', '23081010038'), -- password: 123456
('tina', '25d55ad283aa400af464c76d713c07ad', 'karyawan', '23081010039'), -- password: 12345678
('bambang', 'e10adc3949ba59abbe56e057f20f883e', 'karyawan', '23081010040'), -- password: 123456
('sari', '25d55ad283aa400af464c76d713c07ad', 'karyawan', '23081010041'), -- password: 12345678
('eko', 'e10adc3949ba59abbe56e057f20f883e', 'karyawan', '23081010042'), -- password: 123456
('wati', '25d55ad283aa400af464c76d713c07ad', 'karyawan', '23081010043'), -- password: 12345678
('fajar', 'e10adc3949ba59abbe56e057f20f883e', 'karyawan', '23081010044'), -- password: 123456
('ayu', '25d55ad283aa400af464c76d713c07ad', 'karyawan', '23081010045'), -- password: 12345678
('reza', 'e10adc3949ba59abbe56e057f20f883e', 'karyawan', '23081010046'), -- password: 123456
('salsa', '25d55ad283aa400af464c76d713c07ad', 'karyawan', '23081010047'), -- password: 12345678
('dedi', 'e10adc3949ba59abbe56e057f20f883e', 'karyawan', '23081010048'), -- password: 123456
('mira', '25d55ad283aa400af464c76d713c07ad', 'karyawan', '23081010049'), -- password: 12345678
('indra', 'e10adc3949ba59abbe56e057f20f883e', 'karyawan', '23081010050'), -- password: 123456
('sinta', '25d55ad283aa400af464c76d713c07ad', 'karyawan', '23081010051'), -- password: 12345678
('gilang', 'e10adc3949ba59abbe56e057f20f883e', 'karyawan', '23081010052'), -- password: 123456
('mega', '25d55ad283aa400af464c76d713c07ad', 'karyawan', '23081010053'), -- password: 12345678
('arif', 'e10adc3949ba59abbe56e057f20f883e', 'karyawan', '23081010054'), -- password: 123456
('dwi', '25d55ad283aa400af464c76d713c07ad', 'karyawan', '23081010055'), -- password: 12345678
('yani', 'e10adc3949ba59abbe56e057f20f883e', 'karyawan', '23081010056'), -- password: 123456
('putri', '25d55ad283aa400af464c76d713c07ad', 'karyawan', '23081010057'), -- password: 12345678
('farhan', 'e10adc3949ba59abbe56e057f20f883e', 'karyawan', '23081010058'); -- password: 123456

-- Seeder untuk tabel absensi
INSERT INTO absensi (user_id, timestamp, status) VALUES
(1, '2025-06-10 08:00:00', 'hadir'),
(2, '2025-06-10 08:05:00', 'hadir'),
(3, '2025-06-10 08:10:00', 'izin'),
(4, '2025-06-10 08:00:00', 'hadir'),
(5, '2025-06-10 08:00:00', 'hadir'),
(6, '2025-06-10 08:00:00', 'sakit'),
(7, '2025-06-10 08:00:00', 'hadir'),
(8, '2025-06-10 08:00:00', 'hadir'),
(9, '2025-06-10 08:00:00', 'izin'),
(10, '2025-06-10 08:00:00', 'hadir'),
(11, '2025-06-10 08:00:00', 'hadir'),
(12, '2025-06-10 08:00:00', 'alpha'),
(13, '2025-06-10 08:00:00', 'hadir'),
(14, '2025-06-10 08:00:00', 'hadir'),
(15, '2025-06-10 08:00:00', 'hadir'),
(16, '2025-06-10 08:00:00', 'izin'),
(17, '2025-06-10 08:00:00', 'hadir'),
(18, '2025-06-10 08:00:00', 'hadir'),
(19, '2025-06-10 08:00:00', 'sakit'),
(20, '2025-06-10 08:00:00', 'hadir'),
(21, '2025-06-10 08:00:00', 'hadir'),
(22, '2025-06-10 08:00:00', 'hadir'),
(23, '2025-06-10 08:00:00', 'izin'),
(24, '2025-06-10 08:00:00', 'hadir'),
(25, '2025-06-10 08:00:00', 'hadir'),
(26, '2025-06-10 08:00:00', 'hadir'),
(27, '2025-06-10 08:00:00', 'sakit'),
(28, '2025-06-10 08:00:00', 'hadir'),
(29, '2025-06-10 08:00:00', 'hadir'),
(30, '2025-06-10 08:00:00', 'hadir');

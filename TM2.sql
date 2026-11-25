CREATE DATABASE tugas_pbo;
USE tugas_pbo;
CREATE TABLE mahasiswa (
    nim VARCHAR(10) PRIMARY KEY,
    nama VARCHAR(100) NOT NULL,
    angkatan YEAR NOT NULL
);
CREATE TABLE mata_kuliah (
    kode_mk VARCHAR(15) PRIMARY KEY,
    nama_mk VARCHAR(100) NOT NULL,
    sks TINYINT NOT NULL
);
CREATE TABLE krs (
    nim VARCHAR(10) NOT NULL,
    kode_mk VARCHAR(15) NOT NULL,
    semester VARCHAR(20) NOT NULL,
    nilai CHAR(2) NULL,
    PRIMARY KEY (nim, kode_mk),
    CONSTRAINT fk_krs_mahasiswa FOREIGN KEY (nim)
        REFERENCES mahasiswa(nim) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_krs_matakuliah FOREIGN KEY (kode_mk)
        REFERENCES mata_kuliah(kode_mk) ON DELETE RESTRICT ON UPDATE CASCADE
);
CREATE TABLE peserta_seminar (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nama VARCHAR(100) NOT NULL,
    waktu_daftar TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO mahasiswa VALUES
 ('2408561001', 'Komang Ayu Lestari', 2024),
 ('2408561002', 'Putu Gede Arimbawa', 2024),
 ('2408561003', 'Ni Made Sri Wahyuni', 2024);
INSERT INTO mata_kuliah VALUES
 ('IF2101', 'Pemrograman Berorientasi Objek', 3),
 ('IF2102', 'Basis Data', 3),
 ('IF2103', 'Struktur Data', 3),
 ('IF2199', 'Kapita Selekta', 2);
INSERT INTO krs (nim, kode_mk, semester) VALUES
 ('2408561001', 'IF2101', 'Ganjil 2026/2027'),
 ('2408561001', 'IF2102', 'Ganjil 2026/2027'),
 ('2408561002', 'IF2101', 'Ganjil 2026/2027'),
 ('2408561002', 'IF2199', 'Ganjil 2026/2027'),
 ('2408561003', 'IF2103', 'Ganjil 2026/2027'),
 ('2408561003', 'IF2199', 'Ganjil 2026/2027');
 
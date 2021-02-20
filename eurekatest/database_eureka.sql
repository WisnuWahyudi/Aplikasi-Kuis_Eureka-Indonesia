-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 20, 2021 at 02:35 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `database_eureka`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `ID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`ID`, `Name`, `Image`) VALUES
(1, 'Art / Culture', 'https://th.bing.com/th/id/OIP.lzyRhSofd2iQKBVDABNe5gAAAA?pid=ImgDet&rs=1'),
(2, 'Kotlin', 'https://th.bing.com/th/id/OIP.brhV2W5M_KdFs2vETDFyPwHaHa?pid=ImgDet&rs=1'),
(3, 'Music', 'https://images.template.net/wp-content/uploads/2016/06/21085357/Music-Logos1.jpg'),
(4, 'Tes Wawasan Kebangsaaan', 'https://1.bp.blogspot.com/-1BUYyAAeAKs/W5_49rj9S-I/AAAAAAAACm4/pIY8lAbqmJIT0Qp52mWI056O4N-KG4j5QCLcBGAs/s1600/Materi%2BTWK%2BBahasa%2BIndonesia.jpg'),
(5, 'Tes Intelegasi Umum', 'https://th.bing.com/th/id/Ra58df25c0194537875b779f2ec89e02f?rik=KrdRVqRq3v4vqg&riu=http%3a%2f%2f2.bp.blogspot.com%2f-PkNwXNH9iSo%2fVZN--1VGNuI%2fAAAAAAAABE4%2fAIRohrLRsGU%2fs1600%2ftiu.png&ehk=BE84h%2fc%2fLoN0T21BcHtZ%2fWnDqNEAg10XmwOYcDWcrug%3d&risl=&pid=ImgRaw'),
(6, 'Android', 'https://th.bing.com/th/id/OIP.qQIMtn9IODqUxU6vDO5KYAHaHa?pid=ImgDet&rs=1');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `questionText` text NOT NULL,
  `questionImage` text NOT NULL,
  `answerA` text NOT NULL,
  `answerB` text NOT NULL,
  `answerC` text NOT NULL,
  `answerD` text NOT NULL,
  `correctAnswer` text NOT NULL,
  `IDQ` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`questionText`, `questionImage`, `answerA`, `answerB`, `answerC`, `answerD`, `correctAnswer`, `IDQ`) VALUES
('1. Pengertian karya seni rupa murni adalah karya seni yang lebih mementingkan ...', '', 'A.Teknik pembuatannya', 'B.Keindahan dibandingkan fungsi pakai', 'C.Fungsi pakai dibandingkan keindahan', 'D.Keindahan dibandingkan nilai komersilnya', 'Jawaban yang benar adalah : B.Keindahan dibandingkan fungsi pakai', 1),
('2. Kedudukan struktur tulang dan otot-otot menentukan besar kecil dan cekung tubuh manusia dalam bentuk keseluruhan tubuh dinamakan ...', '', 'A.  Posisi', 'B. Anatomi', 'C. Figuratif', 'D. Proporsi', 'Jawaban yang benar adalah : B. Anatomi', 1),
('3. Proses menggambar yang paling awal atau membuat rancangan gambar dinamakan ...', '', 'A. Mewarnai', 'B.Gambar', 'C.Batik', 'D. Sketsa', 'Jawaban yang benar adalah : D. Sketsa', 1),
('4. Cat yang memiliki kekuatann tembus pandang warna cemerlang yaitu ...', '', 'a. Cat pastel\r\n', 'b. Transparan water colour', 'c. Pensil warna', 'd. Water colour', 'Jawaban yang benar adalah B. Transparan water colour', 1),
('5. Perhatikan gambar dibawah ini! Patung ~Kuda Lari~ yang ada pada gambar dibawah merupakan seni rupa ...', 'https://1.bp.blogspot.com/-WAxIdr2vXRg/XVoWzdubPiI/AAAAAAAAC8I/10_is-QJj1QxEV6VCJ8pf57r1UWwQpIewCLcBGAs/s400/soal%2Btentang%2Bseni%2Brupa.jpg', 'a. Lima dimensi\r\n', 'b. Setengah dimensi', 'c. Dua dimensi', 'd. Tiga dimensi', 'Jawaban yang benar adalah d. Tiga Dimensi', 1),
('', '', '', '', '', '', '', 1),
('Kapan Bahasa Kotlin pertama kali dirilis ? ', '', 'A. February / 2016', 'B. January / 2017', 'C. Maret / 2018', 'D. Desember 2019', 'A. February / 2016', 2),
('Apa yang di umumkan pada acara Google I/O tahun 2019 lalu ? ', '', 'A. Google mengumumkan bahasa Pascal untuk android :D ', 'B. Google mengumumkan C++ First Untuk Android dan tidak di ragukan lagi', 'C. Google mengumumkan Java First And Forever untuk android ', 'D. Google mengumumkan Kotlin First!, yaitu menetapkan Kotlin sebagai bahasa pemrograman nomor 1 (satu) untuk Android', 'D. Google mengumumkan Kotlin First!, yaitu menetapkan Kotlin sebagai bahasa pemrograman nomor 1 (satu) untuk Android', 2),
(' Bagaimana cara menangani objek nullable di kotlin dengan mudah ? ', '', 'A. Safe Call & Elvis Operator ', 'B.Div', 'C. Looping', 'D. Safe Call', 'A. Safe Call & Elvis Operator ', 2),
('Apa nama sertifikasi android tingkat International dari Google atau AAD ? ', '', 'A. Akademi Angkatan Darat', 'B. Akademi Angkatan Development', 'C. Akademi Anjungan Dewan', 'D. Associate Android Developer', 'D. Associate Android Developer', 2),
('Bahasa kotlin lebih ringkas dan fleksibel di bandingkan dengan Java . Apakah benar ?', 'https://d17ivq9b7rppb3.cloudfront.net/original/academy/20190422214347a1250a8d28b371fd02bd9744c3bda72e.png', 'A. Tidak Tau', 'B. Kayanya sih seperti itu', 'C. Benar dan powerfull', 'D. Belum belajar kotlin :(', 'C. Benar dan powerfull', 2),
('Siapa bintang 80-an yang diakui oleh Guinness World Records sebagai artis rekaman wanita terlaris sepanjang masa? ', '', 'A.Bang Qomarudin', 'B.Mas Daroto', 'C.Herlida', 'D.Madonna', 'D.Madonna', 3),
('Siapa yang mendorong dunia untuk \'Get Down on It\' pada tahun 1981? ', '', 'A.Kool dan Geng', 'B.Michaele', 'C.Herlida', 'D.Arif', 'A.Kool dan Geng', 3),
('Siapa bintang pop Amerika yang sukses di tangga lagu 2015 dengan single \'Sorry\' dan \'Love Yourself\'?', '', 'A.Marcus', 'B.Ariel Noah', 'C.Justin Bieber', 'D.Baim', 'C.Justin Bieber', 3),
('Apa nama rekaman pertama Adele?', '', 'A.Hello', 'B.Kemenangan kampung halaman', 'C.Steel Heart', 'D.I Need You', 'B.Kemenangan kampung halaman', 3),
('Apa \'grup pop Amerika 1960-an menciptakan\' suara surfin \'?', 'https://image.slidesharecdn.com/ammusic1-121024231408-phpapp01/95/american-music-1-638.jpg?cb=1351120520', 'A.Dasyat', 'B.Geisha', 'C.Beach Boys', 'D.Indosiar', 'C.Beach Boys', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

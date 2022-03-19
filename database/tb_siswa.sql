-- -------------------------------------------------------------
-- TablePlus 4.6.2(410)
--
-- https://tableplus.com/
--
-- Database: db_siswa
-- Generation Time: 2022-03-19 12:14:44.4640
-- -------------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


CREATE TABLE `tb_siswa` (
  `id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `nama` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `alamat` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `kontak` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `minat` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `tb_siswa` (`id`, `nama`, `alamat`, `kontak`, `minat`) VALUES
('S-00001', 'Aldo Mininda', 'Gudang Minyak', '081267654232', 'IPA'),
('S-00002', 'Adhy Yuri', 'Pantai Indah', '086513456677', 'IPS'),
('S-00003', 'Bambang Sukojo', 'Pramuka', '08978776543', 'IPS'),
('S-00004', 'Chandra', 'Batu 3', '0918291', 'IPS'),
('S-00005', 'Derwin', 'Batu 5', '09989', 'IPS'),
('S-00006', 'Feranika Hutama', 'Batu 10', '87361819', 'IPA'),
('S-00007', 'Gina Rahmawati', 'Batu 8 Atas', '89738101', 'IPA'),
('S-00008', 'Indra Setiawan', 'Dompak', '787191', 'IPA'),
('S-00009', 'Joko Sutrisno', 'Alif Stone ', '6782911', 'IPA'),
('S-00010', 'M. Fathurrayan', 'Ranai Kota', '7682100111', 'IPA');


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
-- -------------------------------------------------------------
-- TablePlus 4.6.2(410)
--
-- https://tableplus.com/
--
-- Database: db_siswa
-- Generation Time: 2022-03-19 12:14:13.2420
-- -------------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


CREATE TABLE `tb_minat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nama_siswa` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `atribut` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nilai_angka` int DEFAULT NULL,
  `nilai_huruf` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `minat` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `id_siswa` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `tb_minat` (`id`, `nama_siswa`, `atribut`, `nilai_angka`, `nilai_huruf`, `minat`, `id_siswa`) VALUES
(2, 'Aldo Mininda', 'IPA', 75, 'IPAB', 'IPA', 'S-00001'),
(3, 'Aldo Mininda', 'IPS', 70, 'IPSC', 'IPA', 'S-00001'),
(4, 'Aldo Mininda', 'MTK', 80, 'MTKB', 'IPA', 'S-00001'),
(5, 'Adhy Yuri', 'IPA', 85, 'IPAB', 'IPS', 'S-00002'),
(6, 'Adhy Yuri', 'IPS', 85, 'IPSB', 'IPS', 'S-00002'),
(7, 'Adhy Yuri', 'MTK', 85, 'MTKB', 'IPS', 'S-00002'),
(8, 'Bambang Sukojo', 'IPA', 80, 'IPAB', 'IPS', 'S-00003'),
(9, 'Bambang Sukojo', 'IPS', 90, 'IPSA', 'IPS', 'S-00003'),
(10, 'Bambang Sukojo', 'MTK', 90, 'MTKA', 'IPS', 'S-00003'),
(11, 'Chandra', 'IPA', 73, 'IPAB', 'IPS', 'S-00004'),
(12, 'Chandra', 'IPS', 75, 'IPSB', 'IPS', 'S-00004'),
(13, 'Chandra', 'MTK', 76, 'MTKB', 'IPS', 'S-00004'),
(14, 'Derwin', 'IPA', 80, 'IPAB', 'IPS', 'S-00005'),
(15, 'Derwin', 'IPS', 88, 'IPSA', 'IPS', 'S-00005'),
(16, 'Derwin', 'MTK', 75, 'MTKB', 'IPS', 'S-00005'),
(17, 'Feranika Hutama', 'IPA', 90, 'IPAA', 'IPA', 'S-00006'),
(18, 'Feranika Hutama', 'IPS', 88, 'IPSA', 'IPA', 'S-00006'),
(19, 'Feranika Hutama', 'MTK', 86, 'MTKA', 'IPA', 'S-00006'),
(20, 'Gina Rahmawati', 'IPA', 86, 'IPAA', 'IPA', 'S-00007'),
(21, 'Gina Rahmawati', 'IPS', 85, 'IPSB', 'IPA', 'S-00007'),
(22, 'Gina Rahmawati', 'MTK', 84, 'MTKB', 'IPA', 'S-00007'),
(23, 'Indra Setiawan', 'IPA', 79, 'IPAB', 'IPA', 'S-00008'),
(24, 'Indra Setiawan', 'IPS', 84, 'IPSB', 'IPA', 'S-00008'),
(25, 'Indra Setiawan', 'MTK', 83, 'MTKB', 'IPA', 'S-00008'),
(26, 'Joko Sutrisno', 'IPA', 88, 'IPAA', 'IPA', 'S-00009'),
(27, 'Joko Sutrisno', 'IPS', 86, 'IPSA', 'IPA', 'S-00009'),
(28, 'Joko Sutrisno', 'MTK', 84, 'MTKB', 'IPA', 'S-00009'),
(29, 'M. Fathurrayan', 'IPA', 90, 'IPAA', 'IPA', 'S-00010'),
(30, 'M. Fathurrayan', 'IPS', 87, 'IPSA', 'IPA', 'S-00010'),
(31, 'M. Fathurrayan', 'MTK', 85, 'MTKB', 'IPA', 'S-00010');


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
-- -------------------------------------------------------------
-- TablePlus 4.6.2(410)
--
-- https://tableplus.com/
--
-- Database: db_siswa
-- Generation Time: 2022-03-19 09:35:50.1340
-- -------------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


CREATE TABLE `tb_keputusan` (
  `id_keputusan` varchar(255) NOT NULL,
  `id_siswa` varchar(255) DEFAULT NULL,
  `nama_siswa` varchar(255) DEFAULT NULL,
  `minat` varchar(255) DEFAULT NULL,
  `jurusan` varchar(255) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `tanggal` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `tb_keputusan` (`id_keputusan`, `id_siswa`, `nama_siswa`, `minat`, `jurusan`, `id`, `tanggal`) VALUES
('K-0001', 'S-00001', 'Aldo Mininda', 'IPA', 'IPA', 21, '2022-03-16'),
('K-0001', 'S-00002', 'Adhy Yuri', 'IPS', 'IPS', 22, '2022-03-16'),
('K-0001', 'S-00003', 'Bambang Sukojo', 'IPS', 'IPS', 23, '2022-03-16'),
('K-0001', 'S-00004', 'Chandra', 'IPS', 'IPS', 24, '2022-03-16'),
('K-0001', 'S-00005', 'Derwin', 'IPS', 'IPS', 25, '2022-03-16'),
('K-0001', 'S-00006', 'Feranika Hutama', 'IPA', 'IPA', 26, '2022-03-16'),
('K-0001', 'S-00007', 'Gina Rahmawati', 'IPA', 'IPA', 27, '2022-03-16'),
('K-0001', 'S-00008', 'Indra Setiawan', 'IPA', 'IPS', 28, '2022-03-16'),
('K-0001', 'S-00009', 'Joko Sutrisno', 'IPA', 'IPA', 29, '2022-03-16'),
('K-0001', 'S-00010', 'M. Fathurrayan', 'IPA', 'IPA', 30, '2022-03-16'),
('K-0002', 'S-00001', 'Aldo Mininda', 'IPA', 'IPA', 31, '2022-03-17'),
('K-0002', 'S-00002', 'Adhy Yuri', 'IPS', 'IPS', 32, '2022-03-17'),
('K-0002', 'S-00003', 'Bambang Sukojo', 'IPS', 'IPS', 33, '2022-03-17'),
('K-0002', 'S-00004', 'Chandra', 'IPS', 'IPS', 34, '2022-03-17'),
('K-0002', 'S-00005', 'Derwin', 'IPS', 'IPS', 35, '2022-03-17'),
('K-0002', 'S-00006', 'Feranika Hutama', 'IPA', 'IPA', 36, '2022-03-17'),
('K-0002', 'S-00007', 'Gina Rahmawati', 'IPA', 'IPA', 37, '2022-03-17'),
('K-0002', 'S-00008', 'Indra Setiawan', 'IPA', 'IPS', 38, '2022-03-17'),
('K-0002', 'S-00009', 'Joko Sutrisno', 'IPA', 'IPA', 39, '2022-03-17'),
('K-0002', 'S-00010', 'M. Fathurrayan', 'IPA', 'IPA', 40, '2022-03-17');


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           8.0.16 - MySQL Community Server - GPL
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para rest_with_spring_boot_udemy
CREATE DATABASE IF NOT EXISTS `rest_with_spring_boot_udemy` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rest_with_spring_boot_udemy`;

-- Copiando estrutura para tabela rest_with_spring_boot_udemy.person
CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) NOT NULL,
  `first_name` varchar(80) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `last_name` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela rest_with_spring_boot_udemy.person: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`id`, `address`, `first_name`, `gender`, `last_name`) VALUES
	(1, 'Av. Santa Marina, 1588', 'Iran', 'Male', 'Feliciano'),
	(2, 'Av. Santa Marina, 1588', 'Erika', 'Female', 'Feliciano'),
	(3, 'Av. Santa Marina, 1588', 'Isabella', 'Female', 'Feliciano'),
	(6, 'Av. Santa Marina, 1588', 'Felipinho', 'Male', 'Feliciano'),
	(7, 'Av. Santa Marina, 1588', 'Isabella', 'Female', 'Feliciano'),
	(8, 'Av. Santa Marina, 1588', 'dssddsdsdsds', 'Male', 'Feliciano'),
	(9, 'Av. Santa Marina, 1588', 'Teste Post', 'Male', 'Feliciano'),
	(10, 'teste teste', 'jevenal', 'Male', 'jevenal'),
	(11, 'teste teste', 'bilu', 'Male', 'bilu');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

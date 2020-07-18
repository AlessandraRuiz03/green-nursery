-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.39-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura para tabla jardineria.calendarioriego
CREATE TABLE IF NOT EXISTS `calendarioriego` (
  `IDCalendario` int(11) NOT NULL AUTO_INCREMENT,
  `TipoProducto` varchar(50) DEFAULT NULL,
  `Dia` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDCalendario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla jardineria.calendarioriego: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `calendarioriego` DISABLE KEYS */;
INSERT INTO `calendarioriego` (`IDCalendario`, `TipoProducto`, `Dia`) VALUES
	(1, 'flores', 'sabado'),
	(2, 'arbol', 'lunes');
/*!40000 ALTER TABLE `calendarioriego` ENABLE KEYS */;

-- Volcando estructura para tabla jardineria.condicion
CREATE TABLE IF NOT EXISTS `condicion` (
  `IDCondicion` int(11) NOT NULL AUTO_INCREMENT,
  `Condicion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDCondicion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla jardineria.condicion: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `condicion` DISABLE KEYS */;
INSERT INTO `condicion` (`IDCondicion`, `Condicion`) VALUES
	(1, 'mala'),
	(3, 'mucha agua');
/*!40000 ALTER TABLE `condicion` ENABLE KEYS */;

-- Volcando estructura para tabla jardineria.historialfoto
CREATE TABLE IF NOT EXISTS `historialfoto` (
  `IDFoto` int(11) NOT NULL AUTO_INCREMENT,
  `IDProducto` varchar(15) DEFAULT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `URL` varchar(50) DEFAULT NULL,
  `FechaFoto` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`IDFoto`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla jardineria.historialfoto: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `historialfoto` DISABLE KEYS */;
INSERT INTO `historialfoto` (`IDFoto`, `IDProducto`, `Nombre`, `URL`, `FechaFoto`) VALUES
	(1, '2', 'flor', 'foto', '27/08/2019'),
	(3, '1', 'apple', 'C://documents/fotos', '27/07/2019'),
	(4, '2', 'mango', 'docuements', '24/08/2019'),
	(5, '5', 'pera', 'documentos', '28/07/2019'),
	(6, '9', 'zanahoria', 'http://imagenes.com', '28/07/2019'),
	(7, '7', 'hoja', 'imagen', '28/07/2019');
/*!40000 ALTER TABLE `historialfoto` ENABLE KEYS */;

-- Volcando estructura para tabla jardineria.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `IDProducto` int(11) NOT NULL AUTO_INCREMENT,
  `TipoProducto` varchar(50) DEFAULT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `FechaIngreso` varchar(20) DEFAULT NULL,
  `Condicion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla jardineria.producto: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`IDProducto`, `TipoProducto`, `Nombre`, `FechaIngreso`, `Condicion`) VALUES
	(3, 'arbol', 'hojita', '26/07/2019', 'mal'),
	(4, 'flor', 'margarita', '26/07/2019', 'buena'),
	(5, 'arbol', 'manzana', '28/07/2019', 'buena'),
	(6, 'planta', 'fresa', '28/07/2019', 'mucha agua'),
	(7, 'q', 'fresa', '28/07/2009', 'mala'),
	(8, 'a', 'b', '12', 'mala');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;

-- Volcando estructura para tabla jardineria.riego
CREATE TABLE IF NOT EXISTS `riego` (
  `IDRiego` int(11) NOT NULL AUTO_INCREMENT,
  `FechaRiego` varchar(20) DEFAULT NULL,
  `TipoProducto` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`IDRiego`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla jardineria.riego: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `riego` DISABLE KEYS */;
INSERT INTO `riego` (`IDRiego`, `FechaRiego`, `TipoProducto`) VALUES
	(1, '26/072019', 'arbol');
/*!40000 ALTER TABLE `riego` ENABLE KEYS */;

-- Volcando estructura para tabla jardineria.tipoproducto
CREATE TABLE IF NOT EXISTS `tipoproducto` (
  `IDTipoProducto` int(11) NOT NULL AUTO_INCREMENT,
  `TipoProducto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDTipoProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla jardineria.tipoproducto: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `tipoproducto` DISABLE KEYS */;
INSERT INTO `tipoproducto` (`IDTipoProducto`, `TipoProducto`) VALUES
	(1, 'planta'),
	(2, 'flor'),
	(5, 'naranja'),
	(6, 'arbol');
/*!40000 ALTER TABLE `tipoproducto` ENABLE KEYS */;

-- Volcando estructura para tabla jardineria.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `Correo` varchar(50) DEFAULT NULL,
  `Contrasena` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla jardineria.usuario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`Correo`, `Contrasena`) VALUES
	('prix.thgdilmr@gmail.com', '123456789'),
	('pris.123@gmail.com', '124879');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

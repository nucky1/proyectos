/*
Navicat MySQL Data Transfer

Source Server         : inmobiliaria
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : im-inmobiliaria

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-11-14 20:39:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for asesor
-- ----------------------------
DROP TABLE IF EXISTS `asesor`;
CREATE TABLE `asesor` (
  `ase_id` int(11) NOT NULL AUTO_INCREMENT,
  `ase_nombre` varchar(30) DEFAULT NULL,
  `ase_telefono` int(11) DEFAULT NULL,
  PRIMARY KEY (`ase_id`),
  UNIQUE KEY `ase_id_UNIQUE` (`ase_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of asesor
-- ----------------------------
INSERT INTO `asesor` VALUES ('1', 'Oficina', '265750517');
INSERT INTO `asesor` VALUES ('2', 'Donald Cormier', '18623462');
INSERT INTO `asesor` VALUES ('3', 'Prof. Hector Weissnat V', '23148');
INSERT INTO `asesor` VALUES ('4', 'Watson Stehr', '34033');
INSERT INTO `asesor` VALUES ('5', 'Mr. Jose Watsica MD', '1828674');
INSERT INTO `asesor` VALUES ('6', 'Kelley Cummerata Jr.', '6828091');
INSERT INTO `asesor` VALUES ('7', 'Brooks Boyer', '273440157');
INSERT INTO `asesor` VALUES ('8', 'Mr. Reagan Pfannerstill DDS', '5724587');
INSERT INTO `asesor` VALUES ('9', 'Leslie Orn', '903190');
INSERT INTO `asesor` VALUES ('10', 'Dr. Eladio Metz', '482915');
INSERT INTO `asesor` VALUES ('11', 'aaaaaaa', '456456');

-- ----------------------------
-- Table structure for cliente
-- ----------------------------
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `cte_id` int(11) NOT NULL AUTO_INCREMENT,
  `cte_asesorID` int(11) NOT NULL,
  `cte_nombre` varchar(30) DEFAULT NULL,
  `cte_tipoDoc` int(11) NOT NULL,
  `cte_doc` varchar(15) NOT NULL,
  `cte_telefono` mediumtext NOT NULL,
  `cte_contacto` varchar(20) DEFAULT NULL,
  `cte_fechaAlta` date DEFAULT NULL,
  PRIMARY KEY (`cte_id`,`cte_asesorID`),
  UNIQUE KEY `cte_id_UNIQUE` (`cte_id`),
  KEY `fk_cliente_asesor1_idx` (`cte_asesorID`),
  CONSTRAINT `fk_cliente_asesor1` FOREIGN KEY (`cte_asesorID`) REFERENCES `asesor` (`ase_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=305 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cliente
-- ----------------------------
INSERT INTO `cliente` VALUES ('1', '2', 'Es Dueño', '1', '456', '4567', '329-72956-1563', '2019-10-15');
INSERT INTO `cliente` VALUES ('2', '1', 'Es Dueño2', '1', '12312312', '121231231', '@EsDueño2', '2019-11-05');
INSERT INTO `cliente` VALUES ('3', '2', 'Es Dueño3', '1', '698694', '761456', '06153028387', '2019-10-15');
INSERT INTO `cliente` VALUES ('4', '9', 'Alquila', '1', '7298', '424358', '(729)225-5971x284', '2019-10-31');
INSERT INTO `cliente` VALUES ('5', '3', 'Alquila1', '1', '525525', '5252', '(729)269-4721-596', '2019-11-12');
INSERT INTO `cliente` VALUES ('6', '1', 'Alquila2', '1', '38438405', '615651516651', 'Contacto (FB,INSTA)', '2019-09-01');
INSERT INTO `cliente` VALUES ('7', '5', 'Dueño4', '1', '40823458', '23554-55256-2234', 'rosasfran.97@gmail.c', '2019-10-23');
INSERT INTO `cliente` VALUES ('8', '10', 'Alquila3', '1', '38438405', '28918932-255658', 'mocciamartin@gmail.c', '2019-11-22');
INSERT INTO `cliente` VALUES ('9', '3', 'Alquila5', '1', '2463475912', '452-52447-52559', 'unemail@gmail.com', '2019-11-21');
INSERT INTO `cliente` VALUES ('10', '3', 'Alquila6', '1', '442785354', '1242-42245-4254', 'unemail2@gmail.com', '2019-11-02');
INSERT INTO `cliente` VALUES ('304', '2', 'Martin', '0', '36681882', '2225', 'unemail@email.com', '2019-11-12');

-- ----------------------------
-- Table structure for infocontrato
-- ----------------------------
DROP TABLE IF EXISTS `infocontrato`;
CREATE TABLE `infocontrato` (
  `infoC_id` int(11) NOT NULL AUTO_INCREMENT,
  `infoC_fecha` date NOT NULL,
  `infoC_observaciones` varchar(1000) DEFAULT NULL,
  `infoC_firma` varchar(20) NOT NULL,
  `infoC_clienteID` int(11) NOT NULL,
  `infoC_inmuebleID` int(11) NOT NULL,
  `infoC_dueñoID` int(11) NOT NULL,
  `infoC_asesorID` int(11) NOT NULL,
  `infoC_tipo` int(2) NOT NULL,
  `infoC_adm_premium` int(2) DEFAULT NULL,
  `infoC_adm_porcentajeAlq` float DEFAULT NULL,
  `infoC_alq_comision` float(20,5) NOT NULL,
  `infoC_alq_aumento` float DEFAULT NULL,
  `infoC_alq_fechaFin` date DEFAULT NULL,
  `infoC_diaVen` int(11) DEFAULT NULL,
  `infoC_alq_fechaInicio` date DEFAULT NULL,
  PRIMARY KEY (`infoC_id`,`infoC_clienteID`,`infoC_dueñoID`,`infoC_asesorID`,`infoC_inmuebleID`),
  KEY `fk_InfoContrato_cliente1_idx` (`infoC_clienteID`),
  KEY `fk_InfoContrato_inmueble1_idx` (`infoC_inmuebleID`,`infoC_dueñoID`),
  KEY `fk_InfoContrato_asesor1_idx` (`infoC_asesorID`),
  CONSTRAINT `fk_InfoContrato_asesor1` FOREIGN KEY (`infoC_asesorID`) REFERENCES `asesor` (`ase_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_InfoContrato_cliente1` FOREIGN KEY (`infoC_clienteID`) REFERENCES `cliente` (`cte_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_InfoContrato_inmueble1` FOREIGN KEY (`infoC_inmuebleID`, `infoC_dueñoID`) REFERENCES `inmueble` (`inm_id`, `inm_dueñoID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of infocontrato
-- ----------------------------
INSERT INTO `infocontrato` VALUES ('1', '2019-11-12', '--', '--', '1', '2', '1', '1', '3', '0', '15', '0.00000', null, null, null, null);
INSERT INTO `infocontrato` VALUES ('46', '2019-11-12', 'Observaciones:\n', 'firma', '304', '2', '1', '8', '1', '0', '25', '5000.00000', '6250', '2021-11-01', '10', '2019-11-01');

-- ----------------------------
-- Table structure for inmueble
-- ----------------------------
DROP TABLE IF EXISTS `inmueble`;
CREATE TABLE `inmueble` (
  `inm_id` int(11) NOT NULL AUTO_INCREMENT,
  `inm_dueñoID` int(11) NOT NULL,
  `inm_direccion` varchar(45) NOT NULL,
  `inm_precio` float NOT NULL,
  `inm_tipo` int(4) NOT NULL,
  `inm_estado` int(11) NOT NULL,
  `inm_habitaciones` int(11) DEFAULT NULL,
  `inm_baños` int(11) DEFAULT NULL,
  `inm_patio` tinyint(1) NOT NULL DEFAULT '0',
  `inm_cocina` tinyint(1) NOT NULL DEFAULT '0',
  `inm_living` tinyint(1) NOT NULL DEFAULT '0',
  `inm_comedor` tinyint(1) NOT NULL DEFAULT '0',
  `inm_cocinaLiving` tinyint(1) NOT NULL DEFAULT '0',
  `inm_cocinaComedor` tinyint(1) NOT NULL DEFAULT '0',
  `inm_cocinaLivingComedor` tinyint(1) NOT NULL DEFAULT '0',
  `inm_MTS2` float DEFAULT NULL,
  `inm_fondo` float DEFAULT NULL,
  `inm_barrio` varchar(30) DEFAULT NULL,
  `inm_garage` tinyint(1) DEFAULT '0',
  `inm_plantaAlta` tinyint(1) NOT NULL DEFAULT '0',
  `inm_impuestos` tinyint(1) NOT NULL DEFAULT '0',
  `inm_servicios` int(2) NOT NULL DEFAULT '0',
  `inm_observaciones` varchar(700) DEFAULT NULL,
  `inm_otros` varchar(500) DEFAULT NULL,
  `inm_operacion` int(2) NOT NULL,
  `inm_lavadero` int(1) NOT NULL,
  `inm_amoblado` int(1) NOT NULL,
  `inm_expensas` double DEFAULT NULL,
  PRIMARY KEY (`inm_id`,`inm_dueñoID`,`inm_servicios`),
  UNIQUE KEY `inmueble_id_UNIQUE` (`inm_id`),
  KEY `fk_inmueble_cliente_idx` (`inm_dueñoID`),
  CONSTRAINT `fk_inmueble_cliente` FOREIGN KEY (`inm_dueñoID`) REFERENCES `cliente` (`cte_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inmueble
-- ----------------------------
INSERT INTO `inmueble` VALUES ('1', '7', 'Martin de loyola 1524', '7500', '1', '1', '5', '2', '1', '1', '1', '1', '1', '1', '1', '150', '15', 'Jubilados', '1', '0', '1', '1', 'No se aceptan mascotas', null, '1', '1', '1', '500');
INSERT INTO `inmueble` VALUES ('2', '1', 'Rivadavia 2100', '5000', '2', '3', '3', '1', '0', '1', '0', '1', '0', '0', '0', '100', '10', 'Centro', '0', '0', '0', '0', 'No se aceptan niños ni mascotas', null, '2', '0', '0', '100');
INSERT INTO `inmueble` VALUES ('3', '2', 'Marcelino 3722', '9500', '3', '3', '2', '1', '0', '0', '0', '0', '0', '0', '0', '150', '15', 'Juan Manuel de Rosas', '0', '0', '1', '1', null, null, '2', '0', '0', '250');
INSERT INTO `inmueble` VALUES ('4', '7', 'Avenida Centenario S/N', '9800', '2', '2', '3', '1', '0', '0', '0', '0', '0', '0', '0', '100', '5', 'Eva Peron', '0', '0', '0', '0', null, null, '1', '0', '0', null);
INSERT INTO `inmueble` VALUES ('5', '3', '25 De Mayo 2516', '5000', '1', '1', '5', '1', '0', '1', '0', '0', '0', '0', '0', '200', '15', 'Centro', '1', '0', '1', '1', null, null, '2', '0', '1', '700');

-- ----------------------------
-- Table structure for pagoalquiler
-- ----------------------------
DROP TABLE IF EXISTS `pagoalquiler`;
CREATE TABLE `pagoalquiler` (
  `pagoA_id` int(11) NOT NULL AUTO_INCREMENT,
  `pagoA_contratoID` int(11) NOT NULL,
  `pagoA_fechaPago` date NOT NULL,
  `pagoA_fechaVencimiento` date NOT NULL,
  `pagoA_punitorios` float NOT NULL DEFAULT '0',
  `pagoA_montoMes` float NOT NULL DEFAULT '0',
  `pagoA_montoLuz` float NOT NULL DEFAULT '0',
  `pagoA_montoGas` float NOT NULL DEFAULT '0',
  `pagoA_montoImp` float NOT NULL DEFAULT '0',
  `pagoA_montoTotal` float NOT NULL,
  `pagoA_montoPago` float NOT NULL,
  `pagoA_completado` tinyint(1) NOT NULL DEFAULT '0',
  `pagoA_rendido` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pagoA_id`),
  KEY `fk_pagoAlquiler_InfoContrato1_idx` (`pagoA_contratoID`),
  CONSTRAINT `fk_pagoAlquiler_InfoContrato1` FOREIGN KEY (`pagoA_contratoID`) REFERENCES `infocontrato` (`infoC_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=377 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pagoalquiler
-- ----------------------------
INSERT INTO `pagoalquiler` VALUES ('352', '46', '2019-11-12', '2019-11-10', '0', '5000', '100', '100', '100', '5300', '5300', '1', '1');
INSERT INTO `pagoalquiler` VALUES ('353', '46', '2019-12-01', '2019-12-10', '0', '5000', '0', '0', '0', '5000', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('354', '46', '2020-01-01', '2020-01-10', '0', '5000', '0', '0', '0', '5000', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('355', '46', '2020-02-01', '2020-02-10', '0', '5000', '0', '0', '0', '5000', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('356', '46', '2020-03-01', '2020-03-10', '0', '5000', '0', '0', '0', '5000', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('357', '46', '2020-04-01', '2020-04-10', '0', '5000', '0', '0', '0', '5000', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('358', '46', '2020-05-01', '2020-05-10', '0', '6250', '0', '0', '0', '6250', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('359', '46', '2020-06-01', '2020-06-10', '0', '6250', '0', '0', '0', '6250', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('360', '46', '2020-07-01', '2020-07-10', '0', '6250', '0', '0', '0', '6250', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('361', '46', '2020-08-01', '2020-08-10', '0', '6250', '0', '0', '0', '6250', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('362', '46', '2020-09-01', '2020-09-10', '0', '6250', '0', '0', '0', '6250', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('363', '46', '2020-10-01', '2020-10-10', '0', '6250', '0', '0', '0', '6250', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('364', '46', '2020-11-01', '2020-11-10', '0', '7850', '0', '0', '0', '7850', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('365', '46', '2020-12-01', '2020-12-10', '0', '7850', '0', '0', '0', '7850', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('366', '46', '2021-01-01', '2021-01-10', '0', '7850', '0', '0', '0', '7850', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('367', '46', '2021-02-01', '2021-02-10', '0', '7850', '0', '0', '0', '7850', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('368', '46', '2021-03-01', '2021-03-10', '0', '7850', '0', '0', '0', '7850', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('369', '46', '2021-04-01', '2021-04-10', '0', '7850', '0', '0', '0', '7850', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('370', '46', '2021-05-01', '2021-05-10', '0', '9850', '0', '0', '0', '9850', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('371', '46', '2021-06-01', '2021-06-10', '0', '9850', '0', '0', '0', '9850', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('372', '46', '2021-07-01', '2021-07-10', '0', '9850', '0', '0', '0', '9850', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('373', '46', '2021-08-01', '2021-08-10', '0', '9850', '0', '0', '0', '9850', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('374', '46', '2021-09-01', '2021-09-10', '0', '9850', '0', '0', '0', '9850', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('375', '46', '2021-10-01', '2021-10-10', '0', '9850', '0', '0', '0', '9850', '0', '0', '0');
INSERT INTO `pagoalquiler` VALUES ('376', '46', '2021-11-01', '2021-11-10', '0', '12350', '0', '0', '0', '12350', '0', '0', '0');

-- ----------------------------
-- Table structure for pagocontrato
-- ----------------------------
DROP TABLE IF EXISTS `pagocontrato`;
CREATE TABLE `pagocontrato` (
  `pagoC_id` int(11) NOT NULL AUTO_INCREMENT,
  `pagoC_montoTotal` float NOT NULL,
  `pagoC_montoPagado` float NOT NULL,
  `pagoC_fechaPago` date NOT NULL,
  `pagoC_infoContratoID` int(11) NOT NULL,
  `pagoC_asesorID` int(11) NOT NULL,
  PRIMARY KEY (`pagoC_id`,`pagoC_infoContratoID`,`pagoC_asesorID`),
  KEY `fk_pagoContrato_InfoContrato1_idx` (`pagoC_infoContratoID`),
  KEY `fk_pagoContrato_asesor1_idx` (`pagoC_asesorID`),
  CONSTRAINT `fk_pagoContrato_InfoContrato1` FOREIGN KEY (`pagoC_infoContratoID`) REFERENCES `infocontrato` (`infoC_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pagoContrato_asesor1` FOREIGN KEY (`pagoC_asesorID`) REFERENCES `asesor` (`ase_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pagocontrato
-- ----------------------------

USE backend;

/*INSET DATA INITIAL*/
/*unidad de medida por defecto bl_unit*/
INSERT INTO `bl_unit` (`name`,`symbol`) VALUES ('METROS CUBICOS', 'M3');#1
INSERT INTO `bl_unit` (`name`,`symbol`) VALUES ('TURBIDEZ', 'NTU');#2
INSERT INTO `bl_unit` (`name`,`symbol`) VALUES ('MICROSIEMENS POR CENTÍMETRO', 'µS/cm');#3
INSERT INTO `bl_unit` (`name`,`symbol`) VALUES ('POR MIL', '‰');#4
INSERT INTO `bl_unit` (`name`,`symbol`) VALUES ('MILIGRAMO POR LITRO', 'mg/l');#5
INSERT INTO `bl_unit` (`name`,`symbol`) VALUES ('UNIDADES DE PLATINO SOBRE COBALTO', 'UPC');#6
INSERT INTO `bl_unit` (`name`,`symbol`) VALUES ('NINGUNA', '-');#7

/*metodos*/
INSERT INTO `p_method` (`name`,`symbol`,`unit_id`)VALUES('pH (25 °C)','APHA 4500-H+ B',7);#1
INSERT INTO `p_method` (`name`,`symbol`,`unit_id`)VALUES('Turbiedad','APHA 2130 B',2);#2
INSERT INTO `p_method` (`name`,`symbol`,`unit_id`)VALUES('Conductividad','APHA 2510 B',3);#3
INSERT INTO `p_method` (`name`,`symbol`,`unit_id`)VALUES('Salinidad','APHA 2520 B',4);#4
INSERT INTO `p_method` (`name`,`symbol`,`unit_id`)VALUES('Sólidos disueltos totales','APHA 2510 B',5);#5
INSERT INTO `p_method` (`name`,`symbol`,`unit_id`)VALUES('Dureza total','APHA 2340 C',5);#6
INSERT INTO `p_method` (`name`,`symbol`,`unit_id`)VALUES('Color Aparente','Colorimetria',6);#7
INSERT INTO `p_method` (`name`,`symbol`,`unit_id`)VALUES('Color Verdadero','Colorimetria',6);#8
INSERT INTO `p_method` (`name`,`symbol`,`unit_id`)VALUES('Cloruro','ATP Orion Method AC2017',5);#9
INSERT INTO `p_method` (`name`,`symbol`,`unit_id`)VALUES('Alcalinidad (pH 8,2)','APHA 2320 B"',5);#10
INSERT INTO `p_method` (`name`,`symbol`,`unit_id`)VALUES('Cobre','Method 8506V',5);#11
INSERT INTO `p_method` (`name`,`symbol`,`unit_id`)VALUES('Sulfato','APHA 4500-SO4²ˉ Eʹʹʹ',5);#12
INSERT INTO `p_method` (`name`,`symbol`,`unit_id`)VALUES('Nitrito','ATP Orion Method AC2046',5);#13
INSERT INTO `p_method` (`name`,`symbol`,`unit_id`)VALUES('Hierro','APHA 3500-Fe IV',5);#14
INSERT INTO `p_method` (`name`,`symbol`,`unit_id`)VALUES('Manganeso','ATP Orion Method AC4P55',5);#15
INSERT INTO `p_method` (`name`,`symbol`,`unit_id`)VALUES('Sílice','APHA 4500-Si D VI',5);#16
INSERT INTO `p_method` (`name`,`symbol`,`unit_id`)VALUES('pH (28 °C)','APHA 4500-H+ B',7);#17

/*datos de los tanques p_tank*/
INSERT INTO `p_tank` (`name`,`water`) VALUES ('TQ-1','AGUA PURIFICADA');
INSERT INTO `p_tank` (`name`,`water`) VALUES ('TQ-2','AGUA PURIFICADA');
INSERT INTO `p_tank` (`name`,`water`) VALUES ('TQ-3','AGUA GENÉRICA');
INSERT INTO `p_tank` (`name`,`water`) VALUES ('TQ-4','ALIMENTACIÓN DE OSMOSIS');
INSERT INTO `p_tank` (`name`,`water`) VALUES ('TQ-5','AGUA ULTRAFILTRADA');
INSERT INTO `p_tank` (`name`,`water`) VALUES ('TQ-6','ALIMENTACIÓN DE ULTRAFILTRACIÓN');
/* eventos para la bit`ácor`a` de p`roduccion tabla p_l_event*/
INSERT INTO `p_l_event` (`name`) VALUES ('PLANTA EN PRODUCCIÓN');#1
INSERT INTO `p_l_event` (`name`) VALUES ('PLANTA DETENIDA');#2
INSERT INTO `p_l_event` (`name`) VALUES ('FLUXING');#3
INSERT INTO `p_l_event` (`name`) VALUES ('RECIBO TURNO');#4
INSERT INTO `p_l_event` (`name`) VALUES ('ENTREGO TURNO');#5
INSERT INTO `p_l_event` (`name`) VALUES ('ASEO');#6
INSERT INTO `p_l_event` (`name`) VALUES ('DESINFECCION');#7
INSERT INTO `p_l_event` (`name`) VALUES ('RETROLAVADOS');#8
INSERT INTO `p_l_event` (`name`) VALUES ('DOSIFICACION');#9

/* MENU*/
/*el icono debe ser el mismo nombre que el path final y la lista que envio debe estar ordenada*/
INSERT INTO `bl_menu` (`module`,`orden`,`title`,`icon`,`path`) VALUES ('INICIO',0,'INICIO','inicio','');
/*MENU PRODUCCION*/
INSERT INTO `bl_menu` (`module`,`orden`,`title`,`icon`,`path`) VALUES ('PRODUCCION',1,'PRODUCCION','produccion','produccion');
/*CONTROL CALIDAD*/
INSERT INTO `bl_menu` (`module`,`orden`,`title`,`icon`,`path`) VALUES ('PRODUCCION',2,'CONTROL DE CALIDAD','control_calidad','produccion/control_calidad');
INSERT INTO `bl_menu` (`module`,`orden`,`title`,`icon`,`path`) VALUES ('PRODUCCION',3,'CALIDAD DE AGUA','agua','produccion/control_calidad/agua');
/*OPERADORES*/
INSERT INTO `bl_menu` (`module`,`orden`,`title`,`icon`,`path`) VALUES ('PRODUCCION',4,'OPERADORES','operadores','produccion/operadores');
INSERT INTO `bl_menu` (`module`,`orden`,`title`,`icon`,`path`) VALUES ('PRODUCCION',5,'VOLUMENES','volumen','produccion/operadores/volumen');
INSERT INTO `bl_menu` (`module`,`orden`,`title`,`icon`,`path`) VALUES ('PRODUCCION',6,'BITÁCORA','bitacora','produccion/operadores/bitacora');
INSERT INTO `bl_menu` (`module`,`orden`,`title`,`icon`,`path`) VALUES ('PRODUCCION',7,'MEDIDOR','medidor','produccion/operadores/medidor');
INSERT INTO `bl_menu` (`module`,`orden`,`title`,`icon`,`path`) VALUES ('PRODUCCION',8,'AGUA PURIFICADA','purificada','produccion/operadores/purificada');
INSERT INTO `bl_menu` (`module`,`orden`,`title`,`icon`,`path`) VALUES ('PRODUCCION',9,'AGUA ULTRAFILTRADA','ultrafiltrada','produccion/operadores/ultrafiltrada');
INSERT INTO `bl_menu` (`module`,`orden`,`title`,`icon`,`path`) VALUES ('PRODUCCION',10,'AGUA GENERICA','generica','produccion/operadores/generica');
/*LISTA DE INFORMES PORDUCCION*/
INSERT INTO `bl_menu` (`module`,`orden`,`title`,`icon`,`path`) VALUES ('PRODUCCION',11,'LISTA DE INFORMES','informe','produccion/informe');
INSERT INTO `bl_menu` (`module`,`orden`,`title`,`icon`,`path`) VALUES ('PRODUCCION',12,'INFORME DE BITÁCORA','bitacora','produccion/informe/bitacora');
INSERT INTO `bl_menu` (`module`,`orden`,`title`,`icon`,`path`) VALUES ('PRODUCCION',13,'INFORME DE MEDIDORES','medidor','produccion/informe/medidor');
INSERT INTO `bl_menu` (`module`,`orden`,`title`,`icon`,`path`) VALUES ('PRODUCCION',14,'INFORME DE CALIDAD DE AGUA','agua','produccion/informe/agua');
#INSERT INTO `bl_menu` (`module`,`orden`,`title`,`icon`,`path`) VALUES ('PRODUCCION',1,'INFORME DE TANQUES','tanque','produccion/datos_maestros/informe/tanque');
INSERT INTO `bl_menu` (`module`,`orden`,`title`,`icon`,`path`) VALUES ('PRODUCCION',15,'INFORME DE VOLUMENES DE AGUA','volumen','produccion/informe/volumen');

/*EL primer turno resgistrado manualmente*/
#USE backend;
#INSERT INTO `p_turn` (`active`,`turn`,`start_date`,`user_id`) VALUES (1,3,'2022-05-12 19:00:00','29be5ffa-bb12-485d-ae77-e8592c3c8f5c');


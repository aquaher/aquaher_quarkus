USE backend;

DROP PROCEDURE IF EXISTS `stp_create_parameter`;
DROP PROCEDURE IF EXISTS `stp_verify_access_turn`;
DROP PROCEDURE IF EXISTS `stp_turn_access`;

DELIMITER $$

CREATE PROCEDURE `stp_create_parameter` (
	IN _tank_id BIGINT,
    IN _lote VARCHAR(255)
)
BEGIN
	SET @fecha = DATE(NOW());
    INSERT INTO `p_quality` (`date`,`lote`) VALUES (@fecha,_lote);
    SET @quality_id = (SELECT `id` FROM `p_quality` WHERE `date` = @fecha AND `lote` = _lote);
    IF _tank_id = 1 OR _tank_id = 2 THEN
		SET @i = 1;
        loop_label:LOOP
			IF @i < 17 THEN
				INSERT INTO `p_parameter` (`method_id`,`quality_id`,`tank_id`) VALUES (@i,@quality_id,_tank_id);
				SET @i = @i + 1;
			ELSE 
				LEAVE loop_label;
			END IF;
			ITERATE loop_label;
		END LOOP;
	ELSEIF _tank_id = 3 OR _tank_id = 5 THEN
		SET @i = 1;
        loop_label:LOOP
			IF @i = 1 THEN
				INSERT INTO `p_parameter` (`method_id`,`quality_id`,`tank_id`) VALUES (17,@quality_id,_tank_id);
				SET @i = @i + 1;
			ELSEIF @i < 9 THEN
				INSERT INTO `p_parameter` (`method_id`,`quality_id`,`tank_id`) VALUES (@i,@quality_id,_tank_id);
				SET @i = @i + 1;
			ELSE 
				LEAVE loop_label;
			END IF;
			ITERATE loop_label;
		END LOOP;
	END IF;
    SELECT * FROM `p_parameter` WHERE `quality_id` = @quality_id AND `tank_id` = _tank_id;
END$$

CREATE PROCEDURE `stp_verify_access_turn` ()
BEGIN
	DECLARE v_start_date DATETIME;
    DECLARE v_end_date DATETIME;
    DECLARE v_operador VARCHAR(255);
	SET @currentdate = NOW();
    SELECT start_date,end_date,operador INTO v_start_date,v_end_date,v_operador FROM `p_turn` WHERE `active` = 1;
    IF @currentdate >= v_start_date AND @currentdate <= v_end_date AND v_operador IS NOT NULL THEN
		SELECT 'registrado';
	ELSEIF @currentdate >= v_end_date THEN
		SELECT 'siguente';
	ELSEIF v_operador IS NULL THEN
		SELECT 'registra';
	END IF;
END$$

CREATE PROCEDURE `stp_turn_access`()
BEGIN
    DECLARE v_turn INTEGER;
    DECLARE v_end_date DATETIME;
    SET @date_actual = NOW();
    SET @date_now = DATE(NOW());
    SET @date_next = DATE(DATE(NOW())+1);
    SET @turn_1 = CONCAT(@date_now,' ',TIME('07:00:00'));
    SET @turn_2 = CONCAT(@date_now,' ',TIME('15:00:00'));
    SET @turn_3 = CONCAT(@date_now,' ',TIME('23:00:00'));
    SET @turn_end = CONCAT(@date_next,' ',TIME('07:00:00'));
    SET @turn_f_2 = CONCAT(@date_now,' ',TIME('19:00:00'));
    SELECT turn,end_date INTO v_turn,v_end_date FROM `p_turn` WHERE `active` = 1;

	IF DAYOFWEEK(NOW()) = 7 OR DAYOFWEEK(NOW()) = 1 THEN
		IF @date_actual >= @turn_1 AND @date_actual <= @turn_f_2 THEN
			IF v_turn <> 1 OR @date_actual>=v_end_date THEN
				UPDATE `p_turn` SET `active` = 0 WHERE (`active` = '1');
				INSERT INTO `p_turn` (start_date,end_date,turn,active) VALUES (@turn_1 ,@turn_f_2 ,1,1);
			END IF;
		END IF;
        IF @date_actual >= @turn_f_2 AND @date_actual <= @turn_end THEN
			IF v_turn <> 2 OR @date_actual>=v_end_date THEN
				UPDATE `p_turn` SET `active` = 0 WHERE (`active` = '1');
				INSERT INTO `p_turn` (start_date,end_date,turn,active) VALUES (@turn_f_2 ,@turn_end ,2,1);
			END IF;
		END IF;
	ELSE
		IF @date_actual >= @turn_1 AND @date_actual <= @turn_2 THEN
			IF v_turn <> 1 OR @date_actual>=v_end_date THEN
				UPDATE `p_turn` SET `active` = 0 WHERE (`active` = '1');
				INSERT INTO `p_turn` (start_date,end_date,turn,active) VALUES (@turn_1 ,@turn_2 ,1,1);
			END IF;
		END IF;
        IF @date_actual >= @turn_2 AND @date_actual <= @turn_3 THEN
			IF v_turn <> 2 OR @date_actual>=v_end_date  THEN
				UPDATE `p_turn` SET `active` = 0 WHERE (`active` = '1');
				INSERT INTO `p_turn` (start_date,end_date,turn,active) VALUES (@turn_2 ,@turn_3 ,2,1);
			END IF;
		END IF;
        IF @date_actual >= @turn_3 AND @date_actual <= @turn_end THEN
			IF v_turn <> 3 OR @date_actual>=v_end_date  THEN
				UPDATE `p_turn` SET `active` = 0 WHERE (`active` = '1');
				INSERT INTO `p_turn` (start_date,end_date,turn,active) VALUES (@turn_3 ,@turn_end ,3,1);
			END IF;
		END IF;
	END IF;
	SELECT * FROM `p_turn` WHERE `active` = 1;
END$$

DELIMITER ;

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
INSERT INTO `p_method` (`name`,`symbol`,`unit_id`)VALUES('Color Aparente','Colorimetria',5);#7
INSERT INTO `p_method` (`name`,`symbol`,`unit_id`)VALUES('Color Verdadero','Colorimetria',5);#8
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
INSERT INTO `p_l_event` (`name`) VALUES ('PLANTA EN PRODUCCIÓN');
INSERT INTO `p_l_event` (`name`) VALUES ('PLANTA DETENIDA');
INSERT INTO `p_l_event` (`name`) VALUES ('FLUXING');
INSERT INTO `p_l_event` (`name`) VALUES ('RECIBO TURNO');
INSERT INTO `p_l_event` (`name`) VALUES ('ENTREGO TURNO');
INSERT INTO `p_l_event` (`name`) VALUES ('ASEO');
INSERT INTO `p_l_event` (`name`) VALUES ('DESINFECCION');
INSERT INTO `p_l_event` (`name`) VALUES ('RETROLAVADOS');
INSERT INTO `p_l_event` (`name`) VALUES ('DOSIFICACION');
/** TURNO*/
INSERT INTO `p_turn` (`start_date`) VALUES ('1900-04-04 07:00:00');

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
#INSERT INTO `bl_menu` (`module`,`orden`,`title`,`icon`,`path`) VALUES ('PRODUCCION',1,'INFORME DE TANQUES','tanque','produccion/datos_maestros/informe/tanque');
INSERT INTO `bl_menu` (`module`,`orden`,`title`,`icon`,`path`) VALUES ('PRODUCCION',14,'INFORME DE VOLUMENES DE AGUA','volumen','produccion/informe/volumen');


/* TABLE KAYCLOAK*/
USE keycloak;
DROP TRIGGER IF EXISTS `after_create_user`;
DROP TRIGGER IF EXISTS `after_delete_user`;
DROP TRIGGER IF EXISTS `after_update_user`;
DELIMITER $$
CREATE TRIGGER after_create_user
	AFTER INSERT ON keycloak.USER_ENTITY
	FOR EACH ROW 
BEGIN
	IF NEW.USERNAME LIKE 'o%' THEN
		INSERT INTO backend.bl_user
		SET 
		id = NEW.ID,
        type = 'operador';
	ELSE
		INSERT INTO backend.bl_user
		SET 
		id = NEW.ID,
        type = 'usuario';
	END IF;
END$$
CREATE TRIGGER after_update_user
	AFTER UPDATE ON keycloak.USER_ENTITY
	FOR EACH ROW 
BEGIN
	UPDATE backend.bl_user
    SET 
    username = CONCAT(NEW.FIRST_NAME,' ', NEW.LAST_NAME)
    WHERE id = NEW.id;
END$$
CREATE TRIGGER after_delete_user
	AFTER DELETE ON keycloak.USER_ENTITY
	FOR EACH ROW 
BEGIN
	DELETE FROM backend.bl_user WHERE id = OLD.ID;
END$$
DELIMITER ;

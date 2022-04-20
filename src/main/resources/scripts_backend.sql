USE backend;

DROP PROCEDURE IF EXISTS `stp_parameter`;
DROP PROCEDURE IF EXISTS `stp_verify_access_turn`;
DROP PROCEDURE IF EXISTS `stp_turn_access`;

DELIMITER $$

CREATE PROCEDURE `stp_parameter` (
	IN _name VARCHAR(255),
	IN _method_id BIGINT,
	IN _quality_id BIGINT, 
	IN _unit_id BIGINT
)
BEGIN
	INSERT INTO `p_parameter`
    (name, method_id, quality_id, unit_id )
    VALUES 
    (_name, _method_id, _quality_id, _unit_id );
    
    SELECT * FROM 
    `p_parameter` 
    ORDER BY id DESC
	LIMIT 1;
END$$

CREATE PROCEDURE `stp_verify_access_turn` ()
BEGIN
	DECLARE v_start_date DATETIME;
    DECLARE v_end_date DATETIME;
    DECLARE v_operador VARCHAR(255);
	SET @currentdate = NOW();
    SELECT start_date,end_date,operador INTO v_start_date,v_end_date,v_operador FROM `p_turn` WHERE id = (SELECT MAX(id) FROM `p_turn`);
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
	DECLARE v_start_date DATETIME;
	DECLARE v_end_date DATETIME;
    DECLARE v_turn INTEGER;
    DECLARE v_operador VARCHAR(255);
    SET @date_time_now = NOW();
    SET @date_now = DATE(NOW());
    SET @date_next = DATE(DATE(NOW())+1);
    SET @turn_1 = CONCAT(@date_now,' ',TIME('07:00:00'));
    SET @turn_2 = CONCAT(@date_now,' ',TIME('15:00:00'));
    SET @turn_3 = CONCAT(@date_now,' ',TIME('23:00:00'));
    SET @turn_end = CONCAT(@date_next,' ',TIME('07:00:00'));
    SET @turn_f_2 = CONCAT(@date_now,' ',TIME('19:00:00'));
    SELECT end_date,start_date,turn,operador INTO  v_end_date,v_start_date,v_turn,v_operador FROM `p_turn` WHERE id = (SELECT MAX(id) FROM `p_turn`);

	IF DAYOFWEEK(NOW()) = 7 OR DAYOFWEEK(NOW()) = 1 THEN
		IF @turn_1= v_start_date AND v_operador IS NOT NULL THEN
			INSERT INTO `p_turn` (start_date,end_date,turn) VALUES (@turn_f_2 ,@turn_end,v_turn + 1);
		ELSEIF v_operador IS NOT NULL THEN
			INSERT INTO `p_turn` (start_date,end_date,turn) VALUES (@turn_1 ,@turn_f_2,1);
		END IF;
	ELSE
		IF @turn_1 = v_start_date AND v_operador IS NOT NULL THEN
			INSERT INTO `p_turn` (end_date,start_date,turn) VALUES (@turn_3 ,@turn_2 ,v_turn + 1);
		ELSEIF @turn_2 = v_start_date AND v_operador IS NOT NULL THEN
			INSERT INTO `p_turn` (end_date,start_date,turn) VALUES (@turn_end ,@turn_3 ,v_turn + 1);
		ELSEIF v_operador IS NOT NULL THEN 
			INSERT INTO `p_turn` (end_date,start_date,turn) VALUES (@turn_2 ,@turn_1 ,1);
		END IF;
	END IF;

	SELECT * FROM `p_turn` WHERE id = (SELECT MAX(id) FROM `p_turn`);
END$$

DELIMITER ;

/*INSET DATA INITIAL*/
/*unidad de medida por defecto bl_unit*/
INSERT INTO `bl_unit` (name,symbol) VALUES ('METROS CUBICOS', 'M3');
/*datos de los tanques p_tank*/
INSERT INTO `p_tank` (name,water) VALUES ('TK-1','AGUA PURIFICADA');
INSERT INTO `p_tank` (name,water) VALUES ('TK-2','AGUA PURIFICADA');
INSERT INTO `p_tank` (name,water) VALUES ('TK-3','AGUA GENÉRICA');
INSERT INTO `p_tank` (name,water) VALUES ('TK-4','AGUA RECHAZO');
INSERT INTO `p_tank` (name,water) VALUES ('TK-5','AGUA ULTRAFILTRADA');
INSERT INTO `p_tank` (name,water) VALUES ('TK-6','AGUA CAPTADA');
/* eventos para la bitácora de produccion tabla p_l_event*/
INSERT INTO `p_l_event` (name) VALUES ('PLANTA EN PRODUCCIÓN');
INSERT INTO `p_l_event` (name) VALUES ('PLANTA DETENIDA');
INSERT INTO `p_l_event` (name) VALUES ('FLUXING');
INSERT INTO `p_l_event` (name) VALUES ('RECIBO TURNO');
INSERT INTO `p_l_event` (name) VALUES ('ENTREGO TURNO');
INSERT INTO `p_l_event` (name) VALUES ('ASEO');
INSERT INTO `p_l_event` (name) VALUES ('DESINFECCION');
INSERT INTO `p_l_event` (name) VALUES ('RETROLAVADOS');
INSERT INTO `p_l_event` (name) VALUES ('DOSIFICACION');
/*métodos de analisis p_method*/
INSERT INTO `p_method` (name) VALUES ('APHA 4500-H^+ B');
INSERT INTO `p_method` (name) VALUES ('APHA 2130 B');
INSERT INTO `p_method` (name) VALUES ('APHA 2510 B');
INSERT INTO `p_method` (name) VALUES ('APHA 2520 B');
INSERT INTO `p_method` (name) VALUES ('APHA 2520 B"');
INSERT INTO `p_method` (name) VALUES ('APHA 2340 C ');
INSERT INTO `p_method` (name) VALUES ('COLORIMETRIA');
INSERT INTO `p_method` (name) VALUES ('ATP ORION METHOD AC2017');
INSERT INTO `p_method` (name) VALUES ('METHOD 8506V');
INSERT INTO `p_method` (name) VALUES ('APHA 4500-SO4^2- E\'"');
INSERT INTO `p_method` (name) VALUES ('ATP ORION METHOD AC2046');
INSERT INTO `p_method` (name) VALUES ('APHA 3500-Fe^IV');
INSERT INTO `p_method` (name) VALUES ('ATP ORION METHOD AC4P55');
INSERT INTO `p_method` (name) VALUES ('APHA 4500-Si D^VI');
INSERT INTO `p_method` (name) VALUES ('ATP ORION METHOD AC3032C');
/** TURNO*/
INSERT INTO `p_turn` (end_date,start_date,turn) VALUES ('2022-04-20 15:00:00','2022-04-20 07:00:00', 1);
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
	IF NEW.USERNAME LIKE '%o%' THEN
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

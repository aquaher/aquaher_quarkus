USE backend;

DROP PROCEDURE IF EXISTS `stp_create_parameter`;
DROP PROCEDURE IF EXISTS `stp_register_turn`;
DROP PROCEDURE IF EXISTS `stp_turn_finalize_and_create`;

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
			ELSE 
				LEAVE loop_label;
			END IF;
            SET @i = @i + 1;
			ITERATE loop_label;
		END LOOP;
	ELSEIF _tank_id = 3 OR _tank_id = 5 THEN
		SET @i = 1;
        loop_label:LOOP
			IF @i = 1 THEN
				INSERT INTO `p_parameter` (`method_id`,`quality_id`,`tank_id`) VALUES (17,@quality_id,_tank_id);
			ELSEIF @i < 9 AND @i > 1 THEN
				INSERT INTO `p_parameter` (`method_id`,`quality_id`,`tank_id`) VALUES (@i,@quality_id,_tank_id);
			ELSE 
				LEAVE loop_label;
			END IF;
            SET @i = @i + 1;
			ITERATE loop_label;
		END LOOP;
	END IF;
    SELECT * FROM `p_parameter` WHERE `quality_id` = @quality_id AND `tank_id` = _tank_id;
END$$

CREATE PROCEDURE `stp_register_turn`(
	IN _turn_id BIGINT,
	IN _user_id VARCHAR(255)
)
BEGIN
	SET @time = TIME(NOW());

	INSERT INTO `p_bitacora` (`start_time`,`end_time`,`section`,`turn_id`,`event_id`,`description`)
	VALUES (@time,@time,'PRODUCCIÓN',_turn_id,4,CONCAT('Inicio de turno'));

	SELECT * FROM `p_turn` WHERE `id` = _turn_id;

END$$

CREATE PROCEDURE `stp_turn_finalize_and_create`(
	IN _turn_id BIGINT,
	IN _user_id VARCHAR(255)
)
BEGIN
	DECLARE _username VARCHAR(255);
	SET @now = NOW();
	SET @date_now = DATE(NOW());
	SET @time = TIME(NOW());
	SET @turn_1 = CONCAT(@date_now,' ',TIME('07:00:00'));
    SET @turn_2 = CONCAT(@date_now,' ',TIME('15:00:00'));
    SET @turn_3 = CONCAT(@date_now,' ',TIME('23:00:00'));
    SET @turn_4 = CONCAT(@date_now,' ',TIME('19:00:00'));

	SELECT `username` INTO _username FROM `bl_user` WHERE `id` = _user_id;
	SET @username = CONCAT('Entrego el turno a',' ',_username);
	UPDATE `p_turn` SET `active` = 0, `end_date` = @now  WHERE `id` = _turn_id;

	INSERT INTO `p_bitacora` (`start_time`,`end_time`,`section`,`turn_id`,`event_id`,`description`)
	VALUES (@time,@time,'PRODUCCIÓN',_turn_id,5,@username );

	IF DAYOFWEEK(NOW()) = 7 OR DAYOFWEEK(NOW()) = 1 THEN
		IF @now >= @turn_1 AND @now <= @turn_4 THEN
			INSERT INTO `p_turn` (`turn`,`start_date`,`user_id`,`active`) VALUES (1,@turn_1,_user_id,1);
		ELSE
			INSERT INTO `p_turn` (`turn`,`start_date`,`user_id`,`active`) VALUES (2,@turn_3,_user_id,1);
		END IF;
	ELSE
		IF @now >= @turn_1 AND @now <= @turn_2 THEN
			INSERT INTO `p_turn` (`turn`,`start_date`,`user_id`,`active`) VALUES (1,@turn_1,_user_id,1);
		ELSEIF @now >= @turn_2 AND @now <= @turn_3 THEN
			INSERT INTO `p_turn` (`turn`,`start_date`,`user_id`,`active`) VALUES (2,@turn_2,_user_id,1);
		ELSE 
			INSERT INTO `p_turn` (`turn`,`start_date`,`user_id`,`active`) VALUES (3,@turn_3,_user_id,1);
		END IF;
	END IF;
	
	SELECT * FROM `p_turn` WHERE `user_id` = _user_id AND `active` = 1;
END$$

DELIMITER ;


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

/*

CREATE PROCEDURE `stp_verify_access_turn` ()
BEGIN
	DECLARE v_start_date DATETIME;
    DECLARE v_end_date DATETIME;
    DECLARE v_operador VARCHAR(255);
	SET @currentdate = NOW();
    SELECT `start_date`,end_date,operador INTO v_start_date,v_end_date,v_operador FROM `p_turn` WHERE `active` = 1;
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
*/
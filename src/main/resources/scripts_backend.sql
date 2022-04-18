USE backend;

DROP PROCEDURE IF EXISTS `stp_parameter`;

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
INSERT INTO `p_method` (name) VALUES ('PRUEBA 1');
INSERT INTO `p_method` (name) VALUES ('PRUEBA 2');
INSERT INTO `p_method` (name) VALUES ('PRUEBA 3');
INSERT INTO `p_method` (name) VALUES ('PRUEBA 4');
INSERT INTO `p_method` (name) VALUES ('PRUEBA 5');
INSERT INTO `p_method` (name) VALUES ('PRUEBA 6');
INSERT INTO `p_method` (name) VALUES ('PRUEBA 7');
INSERT INTO `p_method` (name) VALUES ('PRUEBA 8');
INSERT INTO `p_method` (name) VALUES ('PRUEBA 9');
INSERT INTO `p_method` (name) VALUES ('PRUEBA 10');
INSERT INTO `p_method` (name) VALUES ('PRUEBA 11');
INSERT INTO `p_method` (name) VALUES ('PRUEBA 12');
INSERT INTO `p_method` (name) VALUES ('PRUEBA 13');
INSERT INTO `p_method` (name) VALUES ('PRUEBA 14');
INSERT INTO `p_method` (name) VALUES ('PRUEBA 15');
INSERT INTO `p_method` (name) VALUES ('PRUEBA 16');
INSERT INTO `p_method` (name) VALUES ('PRUEBA 17');
INSERT INTO `p_method` (name) VALUES ('PRUEBA 18');
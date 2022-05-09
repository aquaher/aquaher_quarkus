USE backend;
/** TURNO*/
/* SEMANA 1*/
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-04 07:00:00','Dany Lucas','2022-04-04 15:00:00', 1);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-04 15:00:00','Pedro Garcia','2022-04-04 23:00:00', 2);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-04 23:00:00','Mario Ontaneda','2022-04-05 07:00:00', 3);

INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-05 07:00:00','Dany Lucas','2022-04-05 15:00:00', 1);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-05 15:00:00','Pedro Garcia','2022-04-05 23:00:00', 2);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-05 23:00:00','Mario Ontaneda','2022-04-06 07:00:00', 3);

INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-06 07:00:00','Dany Lucas','2022-04-06 15:00:00', 1);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-06 15:00:00','Pedro Garcia','2022-04-06 23:00:00', 2);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-06 23:00:00','Mario Ontaneda','2022-04-07 07:00:00', 3);

INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-07 07:00:00','Dany Lucas','2022-04-07 15:00:00', 1);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-07 15:00:00','Pedro Garcia','2022-04-07 23:00:00', 2);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-07 23:00:00','Mario Ontaneda','2022-04-08 07:00:00', 3);

INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-08 07:00:00','Dany Lucas','2022-04-08 15:00:00', 1);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-08 15:00:00','Pedro Garcia','2022-04-08 23:00:00', 2);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-08 23:00:00','Mario Ontaneda','2022-04-09 07:00:00', 3);

INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-09 07:00:00','Dany Lucas','2022-04-09 19:00:00', 1);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-09 19:00:00','Pedro Garcia','2022-04-10 07:00:00', 2);

INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-10 07:00:00','Dany Lucas','2022-04-10 19:00:00', 1);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-10 19:00:00','Mario Ontaneda','2022-04-11 07:00:00', 2);
/* SEMANA 2*/
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-11 07:00:00','Dany Lucas','2022-04-11 15:00:00', 1);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-11 15:00:00','Pedro Garcia','2022-04-11 23:00:00', 2);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-11 23:00:00','Mario Ontaneda','2022-04-12 07:00:00', 3);

INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-12 07:00:00','Dany Lucas','2022-04-12 15:00:00', 1);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-12 15:00:00','Pedro Garcia','2022-04-12 23:00:00', 2);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-12 23:00:00','Mario Ontaneda','2022-04-13 07:00:00', 3);

INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-13 07:00:00','Dany Lucas','2022-04-13 15:00:00', 1);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-13 15:00:00','Pedro Garcia','2022-04-13 23:00:00', 2);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-13 23:00:00','Mario Ontaneda','2022-04-14 07:00:00', 3);

INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-14 07:00:00','Dany Lucas','2022-04-14 15:00:00', 1);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-14 15:00:00','Pedro Garcia','2022-04-14 23:00:00', 2);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-14 23:00:00','Mario Ontaneda','2022-04-15 07:00:00', 3);

INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-15 07:00:00','Dany Lucas','2022-04-15 15:00:00', 1);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-15 15:00:00','Pedro Garcia','2022-04-15 23:00:00', 2);
INSERT INTO `p_turn` (start_date,operador,end_date,turn) VALUES ('2022-04-15 23:00:00','Mario Ontaneda','2022-04-15 07:00:00', 3);

/*TANQUE 1 Y 2*/
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,1);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,1);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1200,500,1,2);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,2);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,3);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,3);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,4);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,4);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1200,500,1,5);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,5);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,6);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,6);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,7);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,7);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1200,500,1,8);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,8);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,9);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,9);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,10);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,10);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1200,500,1,11);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,11);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,12);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,12);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,13);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,13);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1200,500,1,14);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,14);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,15);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,15);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,16);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,16);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1200,500,1,17);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,17);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,18);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,18);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,19);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,19);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1200,500,1,20);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,20);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,21);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,21);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,22);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,22);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1200,500,1,23);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,23);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,24);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,24);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,25);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,25);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1200,500,1,26);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,26);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,27);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,27);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,28);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,28);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1200,500,1,29);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,29);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,30);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,30);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,31);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,31);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,32);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,32);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,33);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,33);

INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1100,1200,400,1,34);
INSERT INTO `backend`.`p_water` (`dispatch`,`end_vol`,`start_vol`,`total_produced`,`tank_id`,`turn_id`) VALUES (300,1000,1100,400,2,34);
/*VOLUMENES DE PRUEBA*/
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(400,1,2);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(410,2,2);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(300,3,2);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(200,4,2);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(120,5,2);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(300,6,2);

INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(200,1,3);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(123,2,3);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(312,3,3);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(123,4,3);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(612,5,3);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(821,6,3);

INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(300,1,4);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(223,2,4);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(412,3,4);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(123,4,4);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(512,5,4);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(321,6,4);

INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(420,1,5);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(143,2,5);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(312,3,5);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(163,4,5);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(612,5,5);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(861,6,5);

INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(210,1,6);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(513,2,6);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(152,3,6);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(123,4,6);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(232,5,6);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(611,6,6);

INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(512,1,7);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(124,2,7);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(465,3,7);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(546,4,7);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(723,5,7);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(152,6,7);

INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(512,1,8);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(623,2,8);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(614,3,8);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(613,4,8);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(263,5,8);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(732,6,8);

INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(720,1,9);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(643,2,9);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(312,3,9);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(463,4,9);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(112,5,9);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(261,6,9);

INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(620,1,10);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(743,2,10);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(812,3,10);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(963,4,10);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(412,5,10);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(361,6,10);

INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(612,1,11);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(235,2,11);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(623,3,11);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(724,4,11);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(722,5,11);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(982,6,11);

INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(420,1,12);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(143,2,12);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(312,3,12);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(163,4,12);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(612,5,12);
INSERT INTO `backend`.`p_volumen` (`vol`,`tank_id`,`turn_id`) VALUES(861,6,12);



/*ACCESS menu el id del usuario debe existir*/
/*operador de prueba*/
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (1,'a1be4227-f147-4edc-bd84-008c94aec71c');
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (2,'a1be4227-f147-4edc-bd84-008c94aec71c');
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (3,'a1be4227-f147-4edc-bd84-008c94aec71c');
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (4,'a1be4227-f147-4edc-bd84-008c94aec71c');
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (5,'a1be4227-f147-4edc-bd84-008c94aec71c');
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (6,'a1be4227-f147-4edc-bd84-008c94aec71c');
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (7,'a1be4227-f147-4edc-bd84-008c94aec71c');
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (8,'a1be4227-f147-4edc-bd84-008c94aec71c');
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (9,'a1be4227-f147-4edc-bd84-008c94aec71c');

/* produccion usuario  de prueba*/
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (10,'1b836116-408e-48ba-912e-1cbd49551c20');
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (11,'1b836116-408e-48ba-912e-1cbd49551c20');
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (12,'1b836116-408e-48ba-912e-1cbd49551c20');
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (13,'1b836116-408e-48ba-912e-1cbd49551c20');
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (1,'1b836116-408e-48ba-912e-1cbd49551c20');
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (2,'1b836116-408e-48ba-912e-1cbd49551c20');

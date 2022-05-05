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

/*ACCESS menu el id del usuario debe existir*/
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (1,'228c2292-7349-4533-b7b0-c2618738a136');
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (2,'228c2292-7349-4533-b7b0-c2618738a136');
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (3,'228c2292-7349-4533-b7b0-c2618738a136');
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (4,'228c2292-7349-4533-b7b0-c2618738a136');
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (5,'228c2292-7349-4533-b7b0-c2618738a136');
INSERT INTO `backend`.`bl_access` (`menu_id`,`user_id`) VALUES (6,'228c2292-7349-4533-b7b0-c2618738a136');

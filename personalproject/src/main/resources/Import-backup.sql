

--insert data into football_team
INSERT INTO football_team (team_name,league,manager)values ('Man Utd','EPL','Erik Ten Hag');
INSERT INTO football_team (team_name,league,manager)values	 ('Man City','EPL','Pep Guardiola');
INSERT INTO football_team (team_name,league,manager)values	 ('Liverpool','EPL','Jurgen Klopp');
INSERT INTO football_team (team_name,league,manager)values	 ('Chelsea','EPL','Frank Lampard');
INSERT INTO football_team (team_name,league,manager)values	 ('Arsenal','EPL','Mikel Arteta');
INSERT INTO football_team (team_name,league,manager)values	 ('Barcelona','La Liga','Xavi');
INSERT INTO football_team (team_name,league,manager)values	 ('Real Madrid','La Liga','Carlo Ancelotti');
INSERT INTO football_team (team_name,league,manager)values	 ('Atletico','La Liga','Diego Simeone');
INSERT INTO football_team (team_name,league,manager)values	 ('Sevilla','La Liga','Jose Luis Mendilibar');
INSERT INTO football_team (team_name,league,manager)values	 ('Milan','Serie A','Stefano Pioli');
INSERT INTO football_team (team_name,league,manager)values	 ('Inter','Serie A','Simone Inzaghi');
INSERT INTO football_team (team_name,league,manager)values	 ('Napoli','Serie A','Luciano Spalletti');
INSERT INTO football_team (team_name,league,manager)values	 ('Juventus','Serie A','Massimiliano Allegri');
INSERT INTO football_team (team_name,league,manager)values	 ('Benfica','Liga Portugal Bwin','Roger Schmidt');
INSERT INTO football_team (team_name,league,manager)values	 ('Porto','Liga Portugal Bwin','Sergio Conceicao');
INSERT INTO football_team (team_name,league,manager)values	 ('Sporting','Liga Portugal Bwin','Ruben Amorim');
INSERT INTO football_team (team_name,league,manager)values	 ('PSG','Ligue 1','Christophe Galtier');
INSERT INTO football_team (team_name,league,manager)values	 ('Marseille','Ligue 1','Igor Tudor');
INSERT INTO football_team (team_name,league,manager)values	 ('Monaco','Ligue 1','Philippe Clement');
INSERT INTO football_team (team_name,league,manager)values	 ('Bayern Munich','Bundesliga','Thomas Tuchel');
INSERT INTO football_team (team_name,league,manager)values	 ('Dortmund','Bundesliga','Edin Terzic');

--insert into football_match
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date) values (9,3,1,0,3,'2023-04-21');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date)values	 (20,1,2,1,2,'2023-04-20');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date)values	 (11,3,14,3,6,'2023-04-20');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date)values	 (6,6,17,1,7,'2017-03-08');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date)values	 (3,4,6,0,4,'2019-05-08');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date)values	 (3,7,1,0,7,'2023-03-05');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date)values	 (8,6,9,1,7,'2023-03-05');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date)values	 (4,2,21,0,2,'2023-03-08');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date)values	 (20,2,17,0,2,'2023-03-09');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date)values	 (15,0,11,0,0,'2023-03-15');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date) values	(7,1,3,0,1,'2023-03-16');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date) values (13,1,11,1,2,'2023-04-05');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date) values	 (6,0,7,4,4,'2023-04-06');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date) values	 (14,1,15,2,3,'2023-04-08');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date) values	 (2,3,20,0,3,'2023-04-12');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date) values	 (14,0,11,2,2,'2023-04-12');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date) values	 (10,1,12,0,1,'2023-04-13');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date) values	 (7,2,4,0,2,'2023-04-13');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date) values	 (1,2,4,0,2,'2023-04-14');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date) values	 (13,1,16,0,1,'2023-04-14');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date) values	 (4,0,7,2,2,'2023-04-19');
INSERT INTO football_match (home_team_id,home_team_score,away_team_id,away_team_score,total_score,start_date) values	 (12,1,10,1,2,'2023-04-19');

--insert into odd
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) values (10,1,1.96,3,'2023-04-12',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (10,2,4.59,3,'2023-04-12',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (10,3,5.80,3,'2023-04-12',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (10,4,2.10,3,'2023-04-12',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (10,5,1.92,3,'2023-04-12',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (2,1,2.48,2,'2023-04-12',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (2,2,3.43,2,'2023-04-12',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (2,3,3.98,2,'2023-04-12',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (2,4,2.17,2,'2023-04-12',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (2,5,1.88,2,'2023-04-12',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (3,1,2.25,2,'2023-04-12',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (3,2,3.20,2,'2023-04-12',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (3,3,3.25,2,'2023-04-12',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (3,4,2.30,2,'2023-04-12',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (3,5,2.03,2,'2023-04-12',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (4,1,1.92,3,'2023-04-13',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (4,2,3.75,3,'2023-04-13',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (4,3,5.25,3,'2023-04-13',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (4,4,2.17,3,'2023-04-13',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (4,5,1.95,3,'2023-04-13',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (5,1,1.46,3,'2023-04-14',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (5,2,5.61,3,'2023-04-14',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (5,3,11.00,3,'2023-04-14',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (5,4,2.03,3,'2023-04-14',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (5,5,1.94,3,'2023-04-14',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (6,1,3.06,3,'2023-04-19',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (6,2,3.73,3,'2023-04-19',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (6,3,2.50,3,'2023-04-19',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (6,4,1.90,3,'2023-04-19',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (6,5,2.05,3,'2023-04-19',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (7,1,1.75,3,'2023-04-19',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (7,2,4.06,3,'2023-04-19',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (7,3,5.80,3,'2023-04-19',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (7,4,2.02,3,'2023-04-19',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (7,5,1.95,3,'2023-04-19',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (8,1,2.91,3,'2023-04-20',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (8,2,4.00,3,'2023-04-20',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (8,3,2.54,3,'2023-04-20',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (8,4,1.95,3,'2023-04-20',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (8,5,2.02,3,'2023-04-20',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (9,1,2.24,3,'2023-04-20',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (9,2,3.66,3,'2023-04-20',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (9,3,3.80,3,'2023-04-20',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (9,4,1.97,3,'2023-04-20',1);
INSERT INTO odd (match_id,odd_type,odd_rate,set_score,end_date,house_id) VALUES	 (9,5,1.98,3,'2023-04-20',1);

--insert into odd_type
INSERT INTO odd_type (odd_type) VALUES	 ('win');
INSERT INTO odd_type (odd_type) VALUES	 ('draw');
INSERT INTO odd_type (odd_type) VALUES	 ('lose');
INSERT INTO odd_type (odd_type) VALUES	 ('over');
INSERT INTO odd_type (odd_type) VALUES	 ('under');




--insert into billing_detail
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) values (4	,2	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(4	,3	,200);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(3	,5	,300);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(4	,7	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(5	,9	,500);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(6	,11	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(7	,12	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(8	,13	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(9	,14	,200);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(10	,15	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(11	,16	,300);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(12	,17	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(13	,19	,500);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(14	,33	,600);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(15	,35	,400);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(16	,31	,200);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(17	,32	,300);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(18	,33	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(19	,34	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(20	,35	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(21	,36	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(22	,37	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(23	,38	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(24	,39	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(25	,40	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(26	,41	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(27	,42	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(28	,43	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(29	,44	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(30	,45	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(31	,33	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(32	,23	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(33	,43	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(34	,31	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(35	,20	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(36	,2	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(37	,3	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(38	,5	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(39	,37	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(40	,38	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(41	,39	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(42	,40	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(43	,41	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(44	,42	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(45	,43	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(46	,44	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(47	,45	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(48	,41	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(49	,30	,100);
INSERT INTO invoice_detail (invoice_id,odd_id,bet_amount) VALUES(50	,31	,100);

--insert into billing
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (2,100,'2023-04-09');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (2,200,'2023-04-13');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (3,300,'2023-04-17');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (4,100,'2023-04-05');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (5,500,'2023-04-11');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (6,100,'2023-04-05');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (7,100,'2023-04-18');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (8,100,'2023-04-05');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (9,200,'2023-04-01');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (10,100,'2023-04-15');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (11,300,'2023-04-02');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (12,100,'2023-04-04');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (13,500,'2023-04-04');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (14,600,'2023-04-02');
INSERT INTO invoice (account_id,total_bet,bet_date) values   (15,400,'2023-04-18');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (16,200,'2023-04-13');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (17,300,'2023-04-10');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (18,100,'2023-04-12');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (19,100,'2023-04-14');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (20,100,'2023-04-17');
INSERT INTO invoice (account_id,total_bet,bet_date) values (10,100,'2023-04-02');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (11,100,'2023-04-04');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (12,100,'2023-04-04');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (13,100,'2023-04-02');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (14,100,'2023-04-18');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (15,100,'2023-04-13');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (16,100,'2023-04-10');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (17,100,'2023-04-12');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (18,100,'2023-04-14');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (19,100,'2023-04-17');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (20,100,'2023-04-02');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (6,100,'2023-04-04');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (7,100,'2023-04-04');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (8,100,'2023-04-02');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (9,100,'2023-04-18');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (10,100,'2023-04-13');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (11,100,'2023-04-10');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (12,100,'2023-04-12');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (13,100,'2023-04-14');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (14,100,'2023-04-17');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (15,100,'2023-04-05');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (16,100,'2023-04-11');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (17,100,'2023-04-05');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (8,100,'2023-04-18');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (9,100,'2023-04-05');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (10,100,'2023-04-01');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (11,100,'2023-04-15');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (12,100,'2023-04-02');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (13,100,'2023-04-04');
INSERT INTO invoice (account_id,total_bet,bet_date) VALUES	 (14,100,'2023-04-05');

--insert house
INSERT INTO house (house_name,address,account_id,house_balance) VALUES ('Bet69x','Bet69x.com',1,10000);



insert into assign_authority (account_id, role)values (1,'ROLE_ADMIN');
insert into assign_authority (account_id, role)values (1 ,'ROLE_USER');
insert into assign_authority (account_id, role)values(2	,'ROLE_USER');
insert into assign_authority (account_id, role)values(3	,'ROLE_USER');
insert into assign_authority (account_id, role)values(4	,'ROLE_USER');
insert into assign_authority (account_id, role)values(5	,'ROLE_USER');
insert into assign_authority (account_id, role)values(6	,'ROLE_USER');
insert into assign_authority (account_id, role)values(7	,'ROLE_USER');
insert into assign_authority (account_id, role)values(8	,'ROLE_USER');
insert into assign_authority (account_id, role)values(9	,'ROLE_USER');
insert into assign_authority (account_id, role)values(10	,'ROLE_USER');
insert into assign_authority (account_id, role)values(11	,'ROLE_USER');
insert into assign_authority (account_id, role)values(12, 'ROLE_USER');
insert into assign_authority (account_id, role)values(13	,'ROLE_USER');
insert into assign_authority (account_id, role)values(14	,'ROLE_USER');
insert into assign_authority (account_id, role)values(15,'ROLE_USER');
insert into assign_authority (account_id, role)values(16,'ROLE_USER');
insert into assign_authority (account_id, role)values(17	,'ROLE_USER');
insert into assign_authority (account_id, role)values(18	,'ROLE_USER');
insert into assign_authority (account_id, role)values(19,'ROLE_USER');
insert into assign_authority (account_id, role)values(20	,'ROLE_USER');

--insert into user
INSERT INTO customer (last_name,first_name ,phone) values ('Owner','Rich','911-113-999');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Keane','Kubecka','737-689-9859');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Mackenzie','Wone','532-587-2525');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Haven','Purdom','170-188-3922');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Allyn','Gartside','497-421-2165');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Melanie','Colisbe','842-568-8948');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Mildred','Jacobowicz','662-642-1187');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Mellisa','Orlton','962-726-7574');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Rycca','Brigstock','669-992-4871');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Kendricks','Leftly','991-753-9619');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Ari','Barlow','441-527-3513');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Shae','Schwerin','299-619-4982');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Lisette','Strother','225-925-6552');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Tiffy','Beedle','212-211-1047');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Brod','Mayhow','513-487-5402');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Perry','Gernier','993-369-6382');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Gerick','Pearmain','605-330-5593');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Morganica','Simmon','301-515-6836');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Martguerita','Desport','985-677-4065');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Lilah','Mansion','688-944-7410');
INSERT INTO customer (last_name,first_name ,phone) values	 ('Misty','Flye','358-289-4303');

--Insert data into account--
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES (true,1000.0,'supperRick','$2a$12$EBC1RPnhRIFLMad57I5cTu67RGUGTbnnWAH8x4ZYPg75/TqjdK8OW',1,'superrich69@richer.com');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES  (true,1000.0,'kkubecka0','$2a$10$/SP2WpJq93lDu7jfWAOh.uZhph.XOwZENaJJQ8uN9buZxwmuuC7ze',21,'kkubecka0@umich.edu');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES	  (true,2000.0,'mwones1','$2y$10$8McWuU4/dVaAEL8i11a4/ehrrzm1uG6XJVFm3XbPv7wiwuMSwm/.a',2,'mwones1@dailymail.co.uk');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES	(true,1500.0,'hpurdom2','$2y$10$CjW6RRJrwZ4NCn3MjxYb5.BN4p6jWzE8RH0QowBvBHO3zq5WSmiKa',3,'hpurdom2@bloglines.com');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES	  (true,3000.0,'agartside3','$2y$10$Adml8JtnDO2X9bVcP/9i...IdDMeep8Tt8O0nydoKidOrT6sl6jNO',4,'agartside3@wix.com');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES	 (true,5000.0,'mcolisbe4','$2y$10$lqnyCO3JW4ZlM71l1UXGbOnQLyX59UbdDL69sQQ0hjJG5v4gaA0Pq',5,'mcolisbe4@wikia.com');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES	  (true,1000.0,'mjacobowicz5','$2y$10$wuUTWfBsDGqYPi.rrf9X/ez5c.eqXuWeo2ZhiJxAgQYsuhGNtcMv2',6,'mjacobowicz5@feedburner.com');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES	 (true,5000.0,'morlton6','$2y$10$52zHQan0LjR7qZIZcDMyVegI7BQli9uVSD7wA2WsnVBBz2.5fyGCy',7,'morlton6@wikispaces.com');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES	 (true,5000.0,'rbrigstock7','$2y$10$q9h1eVThjxbXWbbZwBm24ef7Rkz.fE6GQTzMFfY1YyaXFTnrz3Jye',8,'rbrigstock7@joomla.org');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES	 (true,10000.0,'kleftly8','$2y$10$Srs7UqcA2w/xITM7s4srf.Uz221pkmS/6VpNcMS3tSgc6jSYJut5a',9,'kleftly8@homestead.com');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES	 (true,20000.0,'abarlow9','$2y$10$7Z6QxmzPKyNgGnGSGNMg3eMAKOlgJrp7hSoZdxCSecH1MtfBqbUzu',10,'abarlow9@alibaba.com');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) values 	(true,7000.0,'sschwerina','$2y$10$aje44MLVFmF9WhwofXCDpuUoRMquSly5VUtFya3x8RhW/ofvl4OZe',11,'sschwerina@house.gov');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES	  (true,8000.0,'lstrotherb','$2y$10$vez531DYHRYoUykRn3pqY.qHxUPMgAvEb0pJJgO3njLlvjbNSc6oi',12,'lstrotherb@earthlink.net');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES	(true,9000.0,'tbeedlec','$2y$10$3924CgxmCh70COrZtzTl1uU.2Rh6hj8g9nmCxnuJ8Q2WFTkThI8CW',13,'tbeedlec@themeforest.net');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES	 (true,5000.0,'bmayhowd','$2y$10$3I45bvPt57Ku7ga24PusJuwn6nt5TXJZEz87K/MdnYmeVTbkoCL2u',14,'bmayhowd@spotify.com');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES	(true,3000.0,'pgerniere','$2y$10$qsmcmf.6LjrXKC/pkMrhiujBCJZRjw06aLLA3hNZjtlaXrMTUfXd2',15,'pgerniere@pbs.org');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES	  (true,2000.0,'gpearmainf','$2y$10$6odblOVVj/U1KGsXm8VC4usLVHCkjPKt0ZJxvEu4GhuwqfrOMABrC',16,'gpearmainf@surveymonkey.com');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES	 (true,6000.0,'msimmong','$2y$10$ijzxMrCgV/maQYlqA4xqJ.8VJN1hE1eWuVhr5PCjfODY6DoP.NmEa',17,'msimmong@census.gov');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES	 (true,7000.0,'mdesporth','$2y$10$hzPADc2JdmpYgT3lK4CEietdhYSs87Pk4PNJG8ZNWXNebem.Rzi2W',18,'mdesporth@surveymonkey.com');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES	 (true,6000.0,'lmansioni','$2y$10$/.80XNJ5/qySdCA5PA/jduqxzG6WSWx3sRsj9Lqh5mtbuQHaPwgSe',19,'lmansioni@i2i.jp');
INSERT INTO account (active,total_balance,user_name,user_password,customer_id, email) VALUES	 (true,5000.0,'mflyej','$2y$10$6ggdfo4hQ/YbIUZPW130eO3uukOFEqyM5wGloFr1i3IfSjVghA0de',20,'mflyej@ifeng.com');
































































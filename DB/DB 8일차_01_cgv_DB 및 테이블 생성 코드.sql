drop database if exists cgv;
create database cgv;
use cgv;

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
	`mo_num`	int	NOT NULL,
	`mo_title`	varchar(30)	NULL,
	`mo_ genre`	varchar(6)	NULL,
	`mo_age`	varchar(10)	NULL,
	`mo_time`	int	NULL,
	`mo_open_date`	date	NULL,
	`mo_detail`	longtext	NULL,
	`mo_site`	varchar(30)	NULL,
	`mo_thumb`	varchar(50)	NULL
);

DROP TABLE IF EXISTS `movieman`;

CREATE TABLE `movieman` (
	`mm_num`	int	NOT NULL,
	`mm_name`	varchar(30)	NULL,
	`mm_birth`	date	NULL,
	`mm_nation`	varchar(30)	NULL,
	`mm_job`	varchar(10)	NULL,
	`mm_education`	varchar(30)	NULL,
	`mm_family`	varchar(30)	NULL,
	`mm_hobby`	varchar(30)	NULL,
	`mm_physical`	varchar(30)	NULL,
	`mm_site`	varchar(30)	NULL,
	`mm_thumb`	varchar(50)	NULL
);

DROP TABLE IF EXISTS `appearance`;

CREATE TABLE `appearance` (
	`ap_num`	int	NOT NULL,
	`ap_mo_num`	int	NOT NULL,
	`ap_mm_num`	int	NOT NULL,
	`ap_role`	varchar(10)	NULL
);

DROP TABLE IF EXISTS `theater`;

CREATE TABLE `theater` (
	`th_name`	varchar(20)	NOT NULL,
	`th_region`	varchar(10)	NULL,
	`th_addr`	varchar(20)	NULL
);

DROP TABLE IF EXISTS `cinema`;

CREATE TABLE `cinema` (
	`ci_num`	int	NOT NULL,
	`ci_name`	varchar(20)	NULL,
	`ci_type`	varchar(10)	NULL,
	`ci_th_name`	varchar(20)	NOT NULL,
	`ci_max_seat`	int	NULL
);

DROP TABLE IF EXISTS `screen`;

CREATE TABLE `screen` (
	`sc_num`	int	NOT NULL,
	`sc_mo_num`	int	NOT NULL,
	`sc_ci_num`	int	NOT NULL,
	`sc_start_time`	datetime	NULL,
	`sc_pos_seat`	int	NULL,
	`sc_end_time`	datetime	NULL,
	`Field`	VARCHAR(255)	NULL
);

DROP TABLE IF EXISTS `seat`;

CREATE TABLE `seat` (
	`se_num`	int	NOT NULL,
	`se_ci_num`	int	NOT NULL,
	`se_name`	varchar(3)	NULL,
	`se_type`	varchar(10)	NULL,
	`se_use`	char(1)	NULL
);

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
	`us_id`	varchar(15)	NOT NULL,
	`us_pw`	varchar(20)	NULL
);

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
	`bo_num`	int	NOT NULL,
	`bo_us_id`	varchar(15)	NOT NULL,
	`bo_date`	datetime	NULL,
	`bo_state`	char(1)	NULL,
	`bo_amount`	int	NULL,
	`bo_sc_num`	int	NOT NULL,
	`bo_total_price`	int	NULL
);

DROP TABLE IF EXISTS `bookdetail`;

CREATE TABLE `bookdetail` (
	`bd_num`	int	NOT NULL,
	`bd_bo_num`	int	NOT NULL,
	`bd_se_num`	int	NOT NULL,
	`bd_price`	int	NULL
);

ALTER TABLE `movie` ADD CONSTRAINT `PK_MOVIE` PRIMARY KEY (
	`mo_num`
);

ALTER TABLE `movieman` ADD CONSTRAINT `PK_MOVIEMAN` PRIMARY KEY (
	`mm_num`
);

ALTER TABLE `appearance` ADD CONSTRAINT `PK_APPEARANCE` PRIMARY KEY (
	`ap_num`
);

ALTER TABLE `theater` ADD CONSTRAINT `PK_THEATER` PRIMARY KEY (
	`th_name`
);

ALTER TABLE `cinema` ADD CONSTRAINT `PK_CINEMA` PRIMARY KEY (
	`ci_num`
);

ALTER TABLE `screen` ADD CONSTRAINT `PK_SCREEN` PRIMARY KEY (
	`sc_num`
);

ALTER TABLE `seat` ADD CONSTRAINT `PK_SEAT` PRIMARY KEY (
	`se_num`
);

ALTER TABLE `user` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`us_id`
);

ALTER TABLE `book` ADD CONSTRAINT `PK_BOOK` PRIMARY KEY (
	`bo_num`
);

ALTER TABLE `bookdetail` ADD CONSTRAINT `PK_BOOKDETAIL` PRIMARY KEY (
	`bd_num`
);

ALTER TABLE movieman 	CHANGE mm_num mm_num int auto_increment;
ALTER TABLE appearance 	CHANGE ap_num ap_num int auto_increment;
ALTER TABLE movie 		CHANGE mo_num mo_num int auto_increment;
ALTER TABLE screen 		CHANGE sc_num sc_num int auto_increment;
ALTER TABLE cinema 		CHANGE ci_num ci_num int auto_increment;
ALTER TABLE seat 		CHANGE se_num se_num int auto_increment;
ALTER TABLE book 		CHANGE bo_num bo_num int auto_increment;
ALTER TABLE bookdetail 	CHANGE bd_num bd_num int auto_increment;


ALTER TABLE `appearance` ADD CONSTRAINT `FK_movie_TO_appearance_1` FOREIGN KEY (
	`ap_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `appearance` ADD CONSTRAINT `FK_movieman_TO_appearance_1` FOREIGN KEY (
	`ap_mm_num`
)
REFERENCES `movieman` (
	`mm_num`
);

ALTER TABLE `cinema` ADD CONSTRAINT `FK_theater_TO_cinema_1` FOREIGN KEY (
	`ci_th_name`
)
REFERENCES `theater` (
	`th_name`
);

ALTER TABLE `screen` ADD CONSTRAINT `FK_movie_TO_screen_1` FOREIGN KEY (
	`sc_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `screen` ADD CONSTRAINT `FK_cinema_TO_screen_1` FOREIGN KEY (
	`sc_ci_num`
)
REFERENCES `cinema` (
	`ci_num`
);

ALTER TABLE `seat` ADD CONSTRAINT `FK_cinema_TO_seat_1` FOREIGN KEY (
	`se_ci_num`
)
REFERENCES `cinema` (
	`ci_num`
);

ALTER TABLE `book` ADD CONSTRAINT `FK_user_TO_book_1` FOREIGN KEY (
	`bo_us_id`
)
REFERENCES `user` (
	`us_id`
);

ALTER TABLE `book` ADD CONSTRAINT `FK_screen_TO_book_1` FOREIGN KEY (
	`bo_sc_num`
)
REFERENCES `screen` (
	`sc_num`
);

ALTER TABLE `bookdetail` ADD CONSTRAINT `FK_book_TO_bookdetail_1` FOREIGN KEY (
	`bd_bo_num`
)
REFERENCES `book` (
	`bo_num`
);

ALTER TABLE `bookdetail` ADD CONSTRAINT `FK_seat_TO_bookdetail_1` FOREIGN KEY (
	`bd_se_num`
)
REFERENCES `seat` (
	`se_num`
);

-- 브로커 영화에 대한 정보를 추가하는 쿼리, 단 줄거리는 짧게 해도 됨
-- http://www.cgv.co.kr/movies/detail-view/?midx=85829
-- 영화 정보 추가
INSERT INTO `cgv`.`movie` (`mo_title`, `mo_ genre`, `mo_age`, `mo_time`, `mo_open_date`, 
	`mo_detail`, `mo_thumb`) 
VALUES ('브로커', '드라마', '12세이상', '129', '2022-06-08', 
	'베이비 박스, 그곳에서 의도치 않게 만난 이들의 예기치 못한 특별한 여정이 시작된다.', 
	NULL);
-- 배우 정보 추가 
INSERT INTO `cgv`.`movieman` (`mm_name`, `mm_birth`, `mm_nation`, `mm_job`, `mm_site`) VALUES ('송강호', '1967-01-17', '한국', '배우', NULL);
INSERT INTO `cgv`.`movieman` (`mm_name`, `mm_birth`, `mm_nation`, `mm_site`) VALUES ('강동원', '1981-01-18', '한국', NULL);
INSERT INTO `cgv`.`movieman` (`mm_name`, `mm_birth`, `mm_nation`, `mm_job`, `mm_site`) VALUES ('배두나', '1979-10-11', '한국', '배우', NULL);
INSERT INTO `cgv`.`movieman` (`mm_name`, `mm_birth`, `mm_job`) VALUES ('이지은', '1993-05-16', '가수');
INSERT INTO `cgv`.`movieman` (`mm_name`, `mm_birth`, `mm_nation`, `mm_job`) VALUES ('이주영', '1992-02-14', '한국', '배우');
-- 배우가 참여한 영화 정보 추가 
insert into appearance(ap_mo_num, ap_mm_num, ap_role)
	select '1', mm_num, '배우' from movieman;
-- 감독 정보 추가
INSERT INTO `cgv`.`movieman` (`mm_name`, `mm_nation`, `mm_job`) VALUES ('고레에다 히로카즈', '일본', '감독');
-- 감독이 참여한 영화 정보 추가
INSERT INTO `cgv`.`appearance` (`ap_mo_num`, `ap_mm_num`, `ap_role`) VALUES ('1', '10', '감독');

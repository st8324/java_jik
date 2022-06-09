
/* 
회사에서 직원들의 월급을 관리하기 위한 웹사이트를 구축하려 한다.
월급은 각 직급별 기본급, 연차별 추가 수당이 있다.
사원 기본금 : 2200000, 연차별로 100000이 추가
2년차 사원의 월급은 2400000

홍길동 	대리	2	2022-05-05	3000000
이순신	사원	2	2022-05-05	2400000	
홍길동	대리	2	2022-06-05	3000000

사원 정보
- 사번, 이름, 생년월일, 직급, 부서, 주소, 연락처

ERD를 설계

모든 직원들은 직급과 연차에 의해 월급이 결정이 된다
 => 직급과 연차가 같으면 월급이 같다

사원	240	10
대리	280	10

1	홍길동	대리	2	280	10
*/
drop database if exists company;

create database if not exists company;

use company;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
	`em_num`	int	NOT NULL,
	`em_name`	varchar(20)	NULL,
	`em_birth`	date	NULL,
	`em_addr`	varchar(100)	NULL,
	`em_phone`	char(13)	NULL,
	`em_de_name`	varchar(6)	NOT NULL,
	`em_rn_name`	varchar(20)	NOT NULL,
	`em_year`	int	NULL,
	`em_enter`	date	NULL
);

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
	`de_name`	varchar(6)	NOT NULL,
	`de_location`	varchar(20)	NULL
);

DROP TABLE IF EXISTS `rank`;

CREATE TABLE `rank` (
	`rn_name`	varchar(20)	NOT NULL,
	`rn_base`	int	NULL,
	`rn_add`	int	NULL
);

DROP TABLE IF EXISTS `pay`;

CREATE TABLE `pay` (
	`pa_num`	int	NOT NULL,
	`pa_em_num`	int	NOT NULL,
	`pa_date`	date	NULL,
	`pa_salary`	int	NULL,
	`pa_name`	varchar(20)	NULL,
	`pa_year`	int	NULL
);

ALTER TABLE `employee` ADD CONSTRAINT `PK_EMPLOYEE` PRIMARY KEY (
	`em_num`
);

ALTER TABLE `department` ADD CONSTRAINT `PK_DEPARTMENT` PRIMARY KEY (
	`de_name`
);

ALTER TABLE `rank` ADD CONSTRAINT `PK_RANK` PRIMARY KEY (
	`rn_name`
);

ALTER TABLE `pay` ADD CONSTRAINT `PK_PAY` PRIMARY KEY (
	`pa_num`
);

ALTER TABLE `pay` CHANGE pa_num pa_num int auto_increment not null;

ALTER TABLE `employee` ADD CONSTRAINT `FK_department_TO_employee_1` FOREIGN KEY (
	`em_de_name`
)
REFERENCES `department` (
	`de_name`
);

ALTER TABLE `employee` ADD CONSTRAINT `FK_rank_TO_employee_1` FOREIGN KEY (
	`em_rn_name`
)
REFERENCES `rank` (
	`rn_name`
);

ALTER TABLE `pay` ADD CONSTRAINT `FK_employee_TO_pay_1` FOREIGN KEY (
	`pa_em_num`
)
REFERENCES `employee` (
	`em_num`
);

/* 
부서 정보를 입력
 - 개발부 	본관 3층 301호
 - 영업부 	본관 2층 201호
 - 마켓팅부 	본관 2층 202호
 - 디자인부	본관 3층 302호 
 - 기타 
 
직급 정보를 입력
 - 사원 		240	10
 - 대리 		280 10
 - 과장 		320 15
 - 차장 		370 18
 - 이사 		400	20
 - 대표이사	440	30
*/
insert into department values('개발부','본관 3층 301호'), ('영업부','본관 2층 201호'),
('마켓팅부','본관 2층 202호'), ('디자인부','본관 3층 302호 '), ('기타',NULL);
insert into `rank`(rn_name, rn_base, rn_add) values
('사원', 240, 10), ('대리', 280, 10), ('과장', 320, 15),
('차장', 370, 18), ('이사', 400, 20), ('대표이사', 440, 30);

-- 2000001	홍길동	1980-01-01	청주시	010-1234-5678	개발부 	차장 1년차 2000-03-02
-- 2000002	임꺽정	1980-03-01	청주시	010-1234-5679	개발부 	차장 2년차 2000-03-02
-- 2020001	이순신	1995-05-01	청주시	010-1254-5678	마켓팅부 	대리 1년차 2020-03-02
-- 2022001	고길동	1998-12-31	청주시	010-3234-5678	영업부 	사원 0년차 2022-03-02
insert into employee(em_num, em_name, em_birth, em_addr, em_phone, em_de_name, 
em_rn_name, em_year, em_enter) values
(2000001,'홍길동','1980-01-01','청주시','010-1234-5678','개발부','차장',1,'2000-03-02'),
(2000002,'임꺽정','1980-03-01','청주시','010-1234-5679','개발부','차장',2,'2000-03-02'),
(2020001,'이순신','1995-05-01','청주시','010-1254-5678','마켓팅부','대리',1,'2020-03-02'),
(2022001,'고길동','1998-12-31','청주시','010-3234-5678','영업부','사원',0,'2022-03-02');
-- 2000001	홍길동	1980-01-01	청주시	010-1234-5678	개발부 	차장 1년차 2000-03-02
-- 2000002	임꺽정	1980-03-01	청주시	010-1234-5679	개발부 	차장 2년차 2000-03-02
-- 2020001	이순신	1995-05-01	청주시	010-1254-5678	마켓팅부 	대리 1년차 2020-03-02
-- 2022001	고길동	1998-12-31	청주시	010-3234-5678	영업부 	사원 0년차 2022-03-02

-- 2022년 1월 5일에 등록된 모든 사원들의 월급을 지급했다 (1월 월급을 지급) 
insert into pay(pa_em_num, pa_date, pa_salary, pa_name, pa_year)  
	select em_num, '2022-01-05', rn_base + rn_add * em_year, em_rn_name, em_year 
		from employee
		join `rank` on em_rn_name = rn_name
        where em_enter < '2022-01-05';

-- 2022년 2월 5일에 등록된 모든 사원들의 월급을 지급했다 (1월 월급을 지급) 
insert into pay(pa_em_num, pa_date, pa_salary, pa_name, pa_year)  
	select em_num, '2022-02-05', rn_base + rn_add * em_year, em_rn_name, em_year 
		from employee
		join `rank` on em_rn_name = rn_name
        where em_enter < '2022-02-05';

-- 2022년 3월 5일에 등록된 모든 사원들의 월급을 지급했다 (1월 월급을 지급) 
insert into pay(pa_em_num, pa_date, pa_salary, pa_name, pa_year)  
	select em_num, '2022-03-05', rn_base + rn_add * em_year, em_rn_name, em_year 
		from employee
		join `rank` on em_rn_name = rn_name
        where em_enter < '2022-03-05';
-- 2022년 4월 5일에 등록된 모든 사원들의 월급을 지급했다 (1월 월급을 지급) 
insert into pay(pa_em_num, pa_date, pa_salary, pa_name, pa_year)  
	select em_num, '2022-04-05', rn_base + rn_add * em_year, em_rn_name, em_year 
		from employee
		join `rank` on em_rn_name = rn_name
        where em_enter < '2022-04-05';
-- 월급 내역에 직급부분에 기입된 개발부 대신 직급이 들어가도록 수정 
update pay
	set pa_name = (select em_rn_name from employee where pa_em_num = em_num);


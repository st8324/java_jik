
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


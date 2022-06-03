drop database if exists 대학생2;
create database if not exists 대학생2;

use 대학생2;
drop table if exists 교수;
create table if not exists 교수(
	교번 char(10),
    이름 varchar(10),
    primary key(교번)
);
drop table if exists 학생;
create table if not exists 학생(
	학번 char(10),
    이름 varchar(10),
    교번 char(10),
    primary key(학번),
    foreign key(교번) references 교수(교번)
);
drop table if exists 강좌;
create table if not exists 강좌(
	강좌코드 char(6),
    강좌명 varchar(15),
    교번 char(10),
    primary key(강좌코드),
    foreign key(교번) references 교수(교번)
);
drop table if exists 수강;
create table if not exists 수강(
	수강번호 int auto_increment,
    학번 char(10) not null,
    강좌코드 char(6) not null,
    중간 int not null default 0,
    기말 int not null default 0,
    과제 int not null default 0,
    출석 int not null default 0,
    총점 int not null default 0,
    primary key(수강번호),
    foreign key(학번) references 학생(학번),
    foreign key(강좌코드) references 강좌(강좌코드),
	check(총점 <= 100)
);
-- 학번 2022160001 고길동 학생 추가 (160은 컴공, 135는 전자, 123은 기계)
-- 학번 2022160002 홍길동 학생 추가
-- 학번 2022135001 유관순 학생 추가
-- 학번 2022135002 이순신 학생 추가
-- 학번 2022123001 논개 학생 추가
-- 학번 2022123002 세종대왕 학생 추가 
insert into 학생 values('2022160001', '고길동', NULL),
('2022160002', '홍길동', NULL),
('2022135001', '유관순', NULL),
('2022135002', '이순신', NULL),
('2022123001', '논개', NULL),
('2022123002', '세종대왕', NULL);
-- 교번 2022160001 유재석 교수 추가
-- 교번 2022135001 강호동 교수 추가
-- 교수 2022123001 나영석 교수 추가 
insert into 교수 values('2022160001','유재석'),
('2022135001','강호동'),
('2022123001','나영석');
-- 학생들은 학과 교수님들에게 지도를 받음 
update 학생
	set
		교번 = '2022160001'
	where
		학번 like '____160___';
update 학생
	set
		교번 = '2022135001'
	where
		학번 like '____135___';
update 학생
	set
		교번 = '2022123001'
	where
		학번 like '____123___';
-- 강좌코드가 MSC001 대학수학기초 유재석 교수님이 강의
-- 강좌코드가 MSC002 대학영어 나영석 교수님이 강의
-- 강좌코드가 ITC001 컴퓨터개론 유재석 교수님이 강의
-- 강좌코드가 ITE001 기초전기 강호동 교수님이 강의
-- 강좌코드가 ITT001 기초기계 나영석 교수님이 강의
insert into 강좌 select 'MSC001', '대학수학기초', 교번 from 교수 where 이름 = '유재석';
insert into 강좌 select 'MSC002', '대학영어', 교번 from 교수 where 이름 = '나영석';
insert into 강좌 select 'ITC001', '컴퓨터개론', 교번 from 교수 where 이름 = '유재석';
insert into 강좌 select 'ITE001', '기초전기', 교번 from 교수 where 이름 = '강호동';
insert into 강좌 select 'ITT001', '기초기계', 교번 from 교수 where 이름 = '나영석';

-- 고길동 학생은 대학수학기초, 대학영어, 컴퓨터개론을 수강 
-- 홍길동 학생은 대학수학기초, 컴퓨터 개론을 수강
-- 유관순 학생은 대학영어, 기초전기를 수강
-- 이순신 학생은 대학수학기초, 대학영어를 수강
-- 논개 학생은 기초기계를 수강
-- 세종대왕 학생은 대학수학기초, 대학영어, 기초기계를 수강 

insert into 수강(학번, 강좌코드) select '2022160001', 강좌코드 from 강좌 where 강좌명 = '대학수학기초';
insert into 수강(학번, 강좌코드) select '2022160001', 강좌코드 from 강좌 where 강좌명 = '대학영어';
insert into 수강(학번, 강좌코드) select '2022160001', 강좌코드 from 강좌 where 강좌명 = '컴퓨터개론';

insert into 수강(학번, 강좌코드) select '2022160002', 강좌코드 from 강좌 where 강좌명 = '대학수학기초';
insert into 수강(학번, 강좌코드) select '2022160002', 강좌코드 from 강좌 where 강좌명 = '컴퓨터개론';

insert into 수강(학번, 강좌코드) select '2022135001', 강좌코드 from 강좌 where 강좌명 = '대학영어';
insert into 수강(학번, 강좌코드) select '2022135001', 강좌코드 from 강좌 where 강좌명 = '기초전기';

insert into 수강(학번, 강좌코드) select '2022135002', 강좌코드 from 강좌 where 강좌명 = '대학수학기초';
insert into 수강(학번, 강좌코드) select '2022135002', 강좌코드 from 강좌 where 강좌명 = '대학영어';

insert into 수강(학번, 강좌코드) select '2022123001', 강좌코드 from 강좌 where 강좌명 = '기초기계';

insert into 수강(학번, 강좌코드) select '2022123002', 강좌코드 from 강좌 where 강좌명 = '대학수학기초';
insert into 수강(학번, 강좌코드) select '2022123002', 강좌코드 from 강좌 where 강좌명 = '대학영어';
insert into 수강(학번, 강좌코드) select '2022123002', 강좌코드 from 강좌 where 강좌명 = '기초기계';

-- 나영석 교수가 강의하는 강좌 목록 조회 
select 강좌명 from 강좌 where 교번 = (select 교번 from 교수 where 이름 = '나영석');
-- MSC001 강좌를 듣는 학생들 이름을 조회 
select 이름 from 학생 where 학번 = any(select 학번 from 수강 where 강좌코드 = 'MSC001');
select 이름 from 학생 where 학번 in(select 학번 from 수강 where 강좌코드 = 'MSC001');

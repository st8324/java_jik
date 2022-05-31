drop database if exists green;
create database if not exists green ;
use green;

create table student(
	num int default 0, -- default는 생략 가능
    name char(6) default '',
    primary key(num)	-- primary key(속성명)을 통해 기본키를 지정
);
-- 주민번호를 의미하는 reg_num 속성을 추가
alter table student
	add reg_num char(14) not null default '000000-0000000' ;
-- 이름 속성의 길이를 6자에서 7자로 수정 
alter table student 
	modify name char(7);
-- 주민번호 속성을 삭제
-- alter table student drop reg_num;
-- 나이 속성 추가
alter table student
	add age int not null default 1;
-- 나이는 1살 이상 1000살 미만이라는 제약 조건 추가
alter table student
	add constraint check(age >= 1 && age < 1000);
-- 기본키 제거
alter table student
	drop primary key;
-- num를 기본키로 설정
alter table student
	add constraint primary key(num);
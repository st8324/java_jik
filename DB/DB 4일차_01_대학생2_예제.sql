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



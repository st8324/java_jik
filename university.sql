drop database if exists university;
create database university;
use university;
create table professor(
	pr_num char(10) primary key,
    pr_name varchar(10) not null
);
create table subject(
	su_code char(6) primary key,
    su_name varchar(15) not null,
    su_pr_num char(10) not null ,
    foreign key(su_pr_num) references professor(pr_num)
);
create table student(
	st_num char(10) primary key,
    st_name varchar(10) not null,
    st_pr_num char(10) not null ,
    foreign key(st_pr_num) references professor(pr_num)
);
create table course(
	co_num char(10) primary key,
    co_st_num char(10) not null,
    co_su_code char(6) not null ,
    co_mid int not null default 0,
    co_final int not null default 0,
    co_homework int not null default 0,
    co_attendance int not null default 0,
    co_total int not null default 0,
    foreign key(co_st_num) references student(st_num),
    foreign key(co_su_code) references subject(su_code)
);
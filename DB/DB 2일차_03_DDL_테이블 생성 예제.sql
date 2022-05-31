drop database if exists score;
create database if not exists score;
use score;

drop table if exists 학생;
create table if not exists 학생(
	학생번호 	int , -- AUTO_INCREMENT는 기본키에만 설정할 수 있음
    학년 		int 	not null default 1,
    반 		int 	not null default 1,
    번호 		int 		not null default 1,
    이름 char(6),
    primary key(학생번호)
);

drop table if exists 성적;
create table if not exists 성적(
	성적번호 	int,
    학년 		int not null	default 1,
    학기 		int not null	default 1,
    과목명 	char(6),
    primary key(성적번호)
);

drop table if exists 보유;
create table if not exists 보유(
	보유번호 	int,
    기말 		int not null	default 0,
    중간 		int not null	default 0,
    수행 		int not null	default 0,
    학생번호 	int not null,
    성적번호 	int not null,
    primary key(보유번호),
    -- foreign key(학생번호) references 학생(학생번호),
    -- foreign key(성적번호) references 성적(성적번호),
    check(기말 >=0 && 기말 <= 100),
    check(중간 >=0 && 중간 <= 100),
    check(수행 >=0 && 수행 <= 100)
);
-- auto_increment는 기본키로 지정된 속성에 설정하는 키워드기 때문에, 테이블을 생성후 alter를 이용하여 변경
alter table 학생	
	CHANGE 학생번호 학생번호 int auto_increment;
alter table 성적	
	CHANGE 성적번호 성적번호 int auto_increment;
alter table 보유	
	CHANGE 보유번호 보유번호 int auto_increment;
-- 외래키로 지정된 기본키의 옵션을 수정할 수 없기 때문에 각 기본키를 auto_increment로 설정 후 외래키 지정
alter table 보유
	add foreign key(학생번호) references 학생(학생번호);
alter table 보유
	add foreign key(성적번호) references 성적(성적번호);
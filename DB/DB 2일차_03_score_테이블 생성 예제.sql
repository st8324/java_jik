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
-- 1학년 1반 1번 홍길동 학생 정보를 추가하는 쿼리문 작성 
-- 1학년 1반 2번 임꺽정 학생 정보를 추가하는 쿼리문 작성
insert into 학생(학년, 반, 번호, 이름) values(1,1,1,'홍길동'), (1,1,2,'임꺽정');
/* 
- 1학년 1반 1번 학생의 1학년 1학기 국어 성적은 중간 100, 기말 90, 수행 80이다.
  이 정보를 테이블에 추가하는 쿼리를 작성해보세요. 
  1. 학생 테이블에 1학년 1반 1번 학생이 있는지 확인(있다=> 학생번호가 1번. 없으면=>추가)
  2. 성적 테이블에 1학년 1학기 국어 성적을 추가
  3. 보유 테이블에 학생번호가 1번이고, 성적번호가 1이고, 중간 100, 기말 90, 수행 80을 추가
*/
insert into 성적(학년, 학기, 과목명) values(1,1,'국어');
insert into 보유(학생번호, 성적번호, 중간, 기말, 수행) values(1, 1, 100, 90, 80);
insert into 보유(학생번호, 성적번호, 중간, 기말, 수행) values(2, 1, 80, 85, 89);

/* 
- 1학년 1반 3번 이순신 학생의 1학년 1학기 수학 성적은 중간 70, 기말 90, 수행 100이다.
  이 정보를 테이블에 추가하는 쿼리를 작성해보세요. 
  
  1. 학생 테이블에 1학년 1반 3번 이순신 학생이 있는지 확인(있다=> 학생번호를 확인. 없으면=>추가)
  2. 성적 테이블에 1학년 1학기 수학 성적이 있는지 확인(있다=>성적번호를 확인. 없으면=>추가)
  3. 보유 테이블에 학생번호가 3번이고, 성적번호가 2이고, 중간 70, 기말 90, 수행 100을 추가
*/
insert into 학생(학년, 반, 번호, 이름) values(1,1,3,'이순신');
insert into 성적(학년, 학기, 과목명) values(1,1,'수학');
insert into 보유(성적번호, 학생번호, 중간, 기말, 수행) values(2, 3, 70, 90, 100);

-- 1학년 1반 1번 학생의 이름을 고길동으로 수정하는 쿼리
update 학생
	set
		이름 = '고길동'
	where 학년 = 1 and 반 = 1 and 번호 = 1;
-- 보유 테이블에 총점이라는 속성을 추가하는 쿼리문
alter table 보유
	add 총점 int not null default 0;
-- 중간 40%, 기말 50%, 수행 10%를 반영한 점수를 총점에 수정하는 쿼리문 
update 보유
	set
		총점 = 기말 * 0.5 + 중간 * 0.4 + 수행 * 0.1;
        
-- 1학년 1반 1번 학생의 1학년 1학기 국어 성적을 삭제하는 쿼리문
delete from 보유 where 학생번호 = 1 and 성적번호 = 1;
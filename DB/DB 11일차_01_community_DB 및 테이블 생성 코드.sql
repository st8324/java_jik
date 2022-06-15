drop database if exists community;
create database community;
use community;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
	`us_id`	varchar(20)	NOT NULL,
	`us_pw`	varchar(15)	NOT NULL,
	`us_name`	varchar(100)	NOT NULL,
	`us_addr`	varchar(200)	NOT NULL default '',
	`us_phone`	char(13)	NOT NULL,
	`us_authority`	int	NOT NULL default 1
);

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
	`bd_num`	int	NOT NULL,
	`bd_ca_name`	varchar(10)	NOT NULL,
	`bd_title`	varchar(100)	NOT NULL,
	`bd_contents`	longtext	NOT NULL,
	`bd_us_id`	varchar(20)	NOT NULL,
	`bd_reg_date`	datetime	NOT NULL default current_timestamp,
	`bd_up_date`	datetime	NULL,
	`bd_views`	int	NOT NULL default 0,
	`bd_del`	int	NOT NULL default 0,
	`bd_depth`	int	NOT NULL default 1,
	`bd_ori_num`	int	NULL,
	`bd_secret`	int	NOT NULL default 0
);

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
	`ca_name`	varchar(10)	NOT NULL,
	`ca_r_authority`	int	NOT NULL default 0,
	`ca_w_authority`	int	NOT NULL default 1,
	`ca_secret_pos`	int	NOT NULL default 0
);

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
	`fi_num`	int	NOT NULL,
	`fi_ori_name`	varchar(100)	NOT NULL,
	`fi_name`	varchar(150)	NOT  NULL,
	`fi_bd_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `likes`;

CREATE TABLE `likes` (
	`li_num`	int	NOT NULL,
	`li_us_id`	varchar(20)	NOT NULL,
	`li_state`	int	NOT NULL,
	`li_target`	varchar(10)	NOT NULL default 'board',
	`li_target_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
	`co_num`	int	NOT NULL,
	`co_contents`	longtext	NOT NULL,
	`co_us_id`	varchar(20)	NOT NULL,
	`co_bd_num`	int	NOT NULL,
	`co_reg_date`	datetime	NOT NULL default now(),
	`co_secret`	int	NOT NULL default 0,
	`co_ori_num`	int	NULL,
	`co_depth`	int	NOT NULL default 1,
	`co_del`	int	NOT NULL default 0
);

ALTER TABLE `user` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`us_id`
);

ALTER TABLE `board` ADD CONSTRAINT `PK_BOARD` PRIMARY KEY (
	`bd_num`
);



ALTER TABLE `category` ADD CONSTRAINT `PK_CATEGORY` PRIMARY KEY (
	`ca_name`
);

ALTER TABLE `file` ADD CONSTRAINT `PK_FILE` PRIMARY KEY (
	`fi_num`
);


ALTER TABLE `likes` ADD CONSTRAINT `PK_LIKES` PRIMARY KEY (
	`li_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `PK_COMMENT` PRIMARY KEY (
	`co_num`
);

-- 외래키로 지정된 기본키들은 속성을 바꾸기 힘들다 
-- bd_num에 auto_increment로 변경하는 쿼리문 
alter table board change bd_num bd_num int not null auto_increment;
alter table file change fi_num fi_num int not null auto_increment;
alter table likes change li_num li_num int not null auto_increment;
alter table comment change co_num co_num int not null auto_increment;

ALTER TABLE `board` ADD CONSTRAINT `FK_category_TO_board_1` FOREIGN KEY (
	`bd_ca_name`
)
REFERENCES `category` (
	`ca_name`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_user_TO_board_1` FOREIGN KEY (
	`bd_us_id`
)
REFERENCES `user` (
	`us_id`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_board_TO_board_1` FOREIGN KEY (
	`bd_ori_num`
)
REFERENCES `board` (
	`bd_num`
);

ALTER TABLE `file` ADD CONSTRAINT `FK_board_TO_file_1` FOREIGN KEY (
	`fi_bd_num`
)
REFERENCES `board` (
	`bd_num`
);

ALTER TABLE `likes` ADD CONSTRAINT `FK_user_TO_likes_1` FOREIGN KEY (
	`li_us_id`
)
REFERENCES `user` (
	`us_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_user_TO_comment_1` FOREIGN KEY (
	`co_us_id`
)
REFERENCES `user` (
	`us_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_board_TO_comment_1` FOREIGN KEY (
	`co_bd_num`
)
REFERENCES `board` (
	`bd_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_comment_TO_comment_1` FOREIGN KEY (
	`co_ori_num`
)
REFERENCES `comment` (
	`co_num`
);

-- 최고관리자를 등록하는 쿼리 아이디 : admin123 비번 : admin123, 이름 : 관리자, 번호 : 000-0000-0000
insert into user(us_id, us_pw, us_name, us_phone, us_authority)
	values('admin123','admin123', '관리자','000-0000-0000', 10);

insert into user(us_id, us_pw, us_name, us_phone)
	values('abcd1234','abcd1234', '홍길동','020-1234-5678'),
	('qwer1234','qwer1234', '임꺽정','030-1234-5678');

-- 관리자가 게시글 종류에 공지사항, 일반, 문의사항을 등록하는 쿼리문 
-- 공지사항은 최고 관리자만 작성할 수 있고, 회원이상만 읽을 수 있다
-- 일반은 회원이상 작성할 수 있고, 비회원도 읽을 수 있다 
-- 문의사항은 회원이상 작성할 수 있고, 회원 이상만 읽을 수 있고, 비밀글을 작성할 수 있다  
insert into category(ca_name, ca_r_authority, ca_w_authority, ca_secret_pos)
	values('공지사항', 1, 10, 0),('일반', 0, 1,0), ('문의사항',1,1,1);

-- abcd1234회원이 일반 게시글에 제목 : 안녕하세요 내용 : 만나서 반갑습니다. 라는 글을 등록 했다 
-- 최고관리자가 공지사항에 제목 : 공지사항1 내용: 공지사항입니다라는 글을 등록 했다 
-- qwer1234회원이 문의 게시글에 제목 : 문의합니다 내용 : 비번을 바꾸고 싶어요 라는 글을 비밀글로 등록 했다 
insert into board(bd_ca_name, bd_title, bd_contents, bd_us_id, bd_secret)
	values('일반', '안녕하세요', '만나서 반갑습니다.', 'abcd1234', 0),
    ('공지사항', '공지사항1', '공지사항입니다.', 'admin123', 0),
    ('문의사항', '문의합니다', '비번을 바꾸고 싶어요.', 'qwer1234', 1);
update board set bd_ori_num = bd_num where bd_ori_num is null;

insert into board(bd_ca_name, bd_title, bd_contents, bd_us_id, bd_secret, bd_ori_num)
	select '일반', '안녕하세요1', '만나서 반갑습니다1.', 'abcd1234', 0, ifnull(max(bd_num),0)+1 
		from board ;
-- admin123관리자가 3번 게시글에 답글을 남김. 제목 : 문의하신 내용에 답변입니다. 내용 : 비번찾기를 이용하세요.(5번)
-- (bd_depth=>2)
insert into 
	board(bd_ca_name, bd_title, bd_contents, bd_us_id, bd_secret, bd_ori_num, bd_depth)
    select '문의사항', '문의하신 내용에 답변입니다.','비번찾기를 이용하세요.', 'admin123', 0, 
		bd_ori_num, bd_depth+1 from board
		where bd_num = 3;
-- qwer1234회원이 5번 게시글에 답급을 남김. 제목 : 그래도 안되요. 내용 : 비번찾기를 이용해도 안됩니다. 
insert into 
	board(bd_ca_name, bd_title, bd_contents, bd_us_id, bd_secret, bd_ori_num, bd_depth)
    select '문의사항', '그래도 안되요.','비번찾기를 이용해도 안됩니다.', 'qwer1234', 0, 
		bd_ori_num, bd_depth+1 from board
		where bd_num = 5;

-- 3번 게시글을 조회 했을 때(게시글 내용을 확인했을 때) 필요한 쿼리 =>조회수 증가
update board set views = views + 1 where bd_num = 3;

-- 추천/비추천을 했다 => 해당 게시글/댓글에 사용자가 처음 추천/비추하는 경우 => 등록, 아닌 경우 => 수정(삭제) 

-- 1번 게시글에 qwer1234회원이 추천했을 때 쿼리문(게시글을 확인하고, 추천버튼을 클릭했다고 가정)
insert into likes(li_us_id, li_state, li_target, li_target_num)
	values('qwer1234', 1, 'board', 1);
    
-- qwer1234회원이 1번 게시글에 추천을 한번더 눌러 추천을 취소했을 때 쿼리문 
update likes set li_state = 0 
	where li_us_id = 'qwer1234' and li_target_num = 1 and li_target ='board';
    
-- 일반, abcd1234, 제목입니다2, 내용입니다 
-- 첨부파일을 2개 추가 해서 게시글을 등록. 첨부파일을 추가할 때 추가해야하는 게시글의 번호를 안다고 가정 
-- 첨부파일명 : a.txt, uuid_a.txt
-- 첨부파일명 : b.txt, uuid_b.txt
-- 게시글을 등록 => insert
insert into board(bd_ca_name, bd_title, bd_contents, bd_us_id, bd_secret, bd_ori_num)
	select '일반', '제목입니다2', '내용입니다', 'abcd1234', 0, ifnull(max(bd_num),0)+1 
		from board ;
-- 첨부파일들을 등록 => insert
insert file(fi_name, fi_ori_name, fi_bd_num)
	values('uuid_a.txt','a.txt', 7),('uuid_b.txt','b.txt', 7);
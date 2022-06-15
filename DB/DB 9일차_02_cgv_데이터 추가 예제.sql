-- CGV청주성안길 영화관 정보를 추가
insert into theater(th_name, th_region, th_addr)
	values('CGV청주성안길', '대전/충청', '충청북도 청주시 상당구 상당로81번길 33(북문로 1가)');
-- CGV청주성안길 상영관은 총 5개, 각 관에는 좌석이 총 10개, A1,A2~E1,E2
-- 상영관 정보를 추가
-- 좌석 정보를 추가 
insert into cinema(ci_name, ci_type, ci_th_name, ci_max_seat)
	values('1관','2D', 'CGV청주성안길',10),
    ('2관','2D', 'CGV청주성안길',10),
    ('3관','2D', 'CGV청주성안길',10),
    ('4관','2D', 'CGV청주성안길',10),
    ('5관','2D', 'CGV청주성안길',10);
insert into seat(se_ci_num, se_name, se_type, se_use)
	values(1, 'A1', '일반', 'Y'), (1, 'A2', '일반', 'Y'), 
    (1, 'B1', '일반', 'Y'), (1, 'B2', '일반', 'Y'), 
    (1, 'C1', '일반', 'Y'), (1, 'C2', '일반', 'Y'), 
    (1, 'D1', '일반', 'Y'), (1, 'D2', '일반', 'Y'), 
    (1, 'E1', '일반', 'Y'), (1, 'E2', '일반', 'Y') ;
insert into seat(se_ci_num, se_name, se_type, se_use)
	values(2, 'A1', '일반', 'Y'), (2, 'A2', '일반', 'Y'), 
    (2, 'B1', '일반', 'Y'), (2, 'B2', '일반', 'Y'), 
    (2, 'C1', '일반', 'Y'), (2, 'C2', '일반', 'Y'), 
    (2, 'D1', '일반', 'Y'), (2, 'D2', '일반', 'Y'), 
    (2, 'E1', '일반', 'Y'), (2, 'E2', '일반', 'Y') ;
insert into seat(se_ci_num, se_name, se_type, se_use)
	values(3, 'A1', '일반', 'Y'), (3, 'A2', '일반', 'Y'), 
    (3, 'B1', '일반', 'Y'), (3, 'B2', '일반', 'Y'), 
    (3, 'C1', '일반', 'Y'), (3, 'C2', '일반', 'Y'), 
    (3, 'D1', '일반', 'Y'), (3, 'D2', '일반', 'Y'), 
    (3, 'E1', '일반', 'Y'), (3, 'E2', '일반', 'Y') ;
insert into seat(se_ci_num, se_name, se_type, se_use)
	values(4, 'A1', '일반', 'Y'), (4, 'A2', '일반', 'Y'), 
    (4, 'B1', '일반', 'Y'), (4, 'B2', '일반', 'Y'), 
    (4, 'C1', '일반', 'Y'), (4, 'C2', '일반', 'Y'), 
    (4, 'D1', '일반', 'Y'), (4, 'D2', '일반', 'Y'), 
    (4, 'E1', '일반', 'Y'), (4, 'E2', '일반', 'Y') ;
insert into seat(se_ci_num, se_name, se_type, se_use)
	values(5, 'A1', '일반', 'Y'), (5, 'A2', '일반', 'Y'), 
    (5, 'B1', '일반', 'Y'), (5, 'B2', '일반', 'Y'), 
    (5, 'C1', '일반', 'Y'), (5, 'C2', '일반', 'Y'), 
    (5, 'D1', '일반', 'Y'), (5, 'D2', '일반', 'Y'), 
    (5, 'E1', '일반', 'Y'), (5, 'E2', '일반', 'Y') ;

-- CGV제주 영화관 정보를 추가
insert into theater(th_name, th_region, th_addr)
	values('CGV제주', '광주/전라/제주', '제주특별자치도 제주시 서광로 288, 3층~7층(이도2동)');
-- CGV제주 상영관은 총 3개, 각 관에는 좌석이 총 8개, A1~3, B1~3, C1~2
insert into cinema(ci_name, ci_type, ci_th_name, ci_max_seat)
	values('1관','2D', 'CGV제주',8),
    ('2관','2D', 'CGV제주',8),
    ('3관','2D', 'CGV제주',8);
insert into seat(se_ci_num, se_name, se_type, se_use)
	values(6, 'A1', '일반', 'Y'), (6, 'A2', '일반', 'Y'), (6, 'A3', '일반', 'Y'),
    (6, 'B1', '일반', 'Y'), (6, 'B2', '일반', 'Y'), (6, 'B3', '일반', 'Y'),
    (6, 'C1', '일반', 'Y'), (6, 'C2', '일반', 'Y') ;
insert into seat(se_ci_num, se_name, se_type, se_use)
	values(7, 'A1', '일반', 'Y'), (7, 'A2', '일반', 'Y'), (7, 'A3', '일반', 'Y'),
    (7, 'B1', '일반', 'Y'), (7, 'B2', '일반', 'Y'), (7, 'B3', '일반', 'Y'),
    (7, 'C1', '일반', 'Y'), (7, 'C2', '일반', 'Y') ;
insert into seat(se_ci_num, se_name, se_type, se_use)
	values(8, 'A1', '일반', 'Y'), (8, 'A2', '일반', 'Y'), (8, 'A3', '일반', 'Y'),
    (8, 'B1', '일반', 'Y'), (8, 'B2', '일반', 'Y'), (8, 'B3', '일반', 'Y'),
    (8, 'C1', '일반', 'Y'), (8, 'C2', '일반', 'Y') ;
-- 브로커 6/14일 CGV성안길 일정을 추가
-- 브로커 : 1
insert into screen(sc_mo_num, sc_ci_num, sc_start_time, sc_pos_seat, sc_end_time)
	values(1, 1, '2022-06-14 11:30', 10, '2022-06-14 13:49'),
    (1, 1, '2022-06-14 14:05', 10, '2022-06-14 16:24'),
    (1, 1, '2022-06-14 16:40', 10, '2022-06-14 18:59'),
    (1, 2, '2022-06-14 10:25', 10, '2022-06-14 12:44'),
    (1, 2, '2022-06-14 13:00', 10, '2022-06-14 15:19'),
    (1, 2, '2022-06-14 15:35', 10, '2022-06-14 17:49'),
    (1, 2, '2022-06-14 18:10', 10, '2022-06-14 20:29'),
    (1, 2, '2022-06-14 20:45', 10, '2022-06-14 23:04'),
    (1, 2, '2022-06-14 23:20', 10, '2022-06-15 01:39'),
    (1, 3, '2022-06-14 11:00', 10, '2022-06-14 13:19'),
    (1, 3, '2022-06-14 13:35', 10, '2022-06-14 15:54'),
    (1, 3, '2022-06-14 16:10', 10, '2022-06-14 16:29'),
    (1, 3, '2022-06-14 18:45', 10, '2022-06-14 21:04'),
    (1, 3, '2022-06-14 21:15', 10, '2022-06-14 23:34'),
    (1, 3, '2022-06-14 23:45', 10, '2022-06-15 02:04');

-- abc123회원인 가입, 비번은 abc123 
insert into user(us_id, us_pw) values('abc123', 'abc123');

-- abc123회원이 6/14일 CGV청주성안길에서 11:30에 하는 영화 브로커 A1, A2좌석을 예매, 가격은 자리당 10000원 
-- 예매를 추가 book테이블 데이터 추가 
insert into book(bo_us_id, bo_date, bo_state, bo_amount, bo_sc_num, bo_total_price)
	select 'abc123', now(), 'Y', 2, sc_num, 20000 from screen
		join movie on sc_mo_num = mo_num
		where sc_start_time = '2022-06-14 11:30:00' and mo_title = '브로커';

-- 예매 내역을 추가 bookdetail테이블 데이터 추가 
-- insert into bookdetail(bd_bo_num, bd_se_num, bd_price)
-- 	values(1, 1, 10000), (1, 2, 10000);
insert into bookdetail(bd_bo_num, bd_se_num, bd_price)
	select 1, se_num, 10000 from screen  -- 상영 정보로 검색 
		join movie on sc_mo_num = mo_num -- 영화 제목으로 검색
        join seat on se_ci_num = sc_ci_num
        where mo_title ='브로커' and sc_start_time = '2022-06-14 11:30:00' 
			and se_name in('A1', 'A2') and se_use = 'Y';
-- abc123회원이 6/14일 CGV청주성안길에서 11:30에 하는 영화 브로커 C1, C2좌석을 예매, 가격은 자리당 10000원 
-- 예매를 추가 book테이블 데이터 추가 
insert into book(bo_us_id, bo_date, bo_state, bo_amount, bo_sc_num, bo_total_price)
	select 'abc123', now(), 'Y', 2, sc_num, 20000 from screen
		join movie on sc_mo_num = mo_num
		where sc_start_time = '2022-06-14 11:30:00' and mo_title = '브로커';

-- 예매 내역을 추가 bookdetail테이블 데이터 추가 
-- insert into bookdetail(bd_bo_num, bd_se_num, bd_price)
-- 	values(2, 5, 10000), (2, 6, 10000);
insert into bookdetail(bd_bo_num, bd_se_num, bd_price)
	select 2, se_num, 10000 from screen  -- 상영 정보로 검색 
		join movie on sc_mo_num = mo_num -- 영화 제목으로 검색
        join seat on se_ci_num = sc_ci_num
        where mo_title ='브로커' and sc_start_time = '2022-06-14 11:30:00' 
			and se_name in('C1', 'C2') and se_use = 'Y';


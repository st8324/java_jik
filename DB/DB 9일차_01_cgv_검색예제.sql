-- 송강호가 출연한 영화 제목들을 조회
select mo_title from movie 
	join appearance on ap_mo_num = mo_num
    join (select * from movieman where mm_name = '송강호') as mm on ap_mm_num = mm_num;
    
-- 고레에다 히로카즈 감독의 영화 제목들을 조회 
select mo_title from movie 
	join (select * from appearance where ap_role='감독') as ap on ap_mo_num = mo_num
    join (select * from movieman where mm_name = '고레에다 히로카즈') as mm 
		on ap_mm_num = mm_num;
-- 장르가 드라마인 영화를 조회 
select mo_title from movie where mo_genre like '%드라마%';

-- 2022/06/14일 CGV청주성안길에서 상영하는 영화 브로커 상영시간표를 조회 
select mo_title as 제목, ci_th_name as 영화관, ci_name as 상영관, sc_start_time as 상영시간
	from screen 
	join movie on sc_mo_num = mo_num -- 영화 제목을 위해 join
    join cinema on sc_ci_num = ci_num -- 지점을 위해 join 
    where mo_title = '브로커' 
		and ci_th_name = 'CGV청주성안길' 
        and sc_start_time like '2022-06-14%'; 
-- 6/14일 CGV청주성안길에서 11:30에 하는 영화 브로커를 상영하는 관의 자석을 조회
-- 6/14일 CGV청주성안길에서 11:30에 하는 영화 브로커에 예매 가능한 좌석을 조회  
-- 예매 테이블을 고려 

select mo_title as 제목, ci_th_name as 영화관, ci_name as 상영관, sc_start_time as 상영시간, 
	se_name as 좌석명, count(bd_bo_num) as 예약수
	from screen 
	join movie on sc_mo_num = mo_num 
    join cinema on sc_ci_num = ci_num
    join seat on se_ci_num = ci_num
    left join book on sc_num = bo_sc_num
    left join bookdetail on bo_num = bd_bo_num and bd_se_num = se_num
    where mo_title = '브로커' 
		and ci_th_name = 'CGV청주성안길' 
        and sc_start_time like '2022-06-14 11:30:00'
	group by 좌석명
    having count(bd_bo_num) = 0; -- 예약이 안된 좌석들을 표시 

-- 브로커를 상영하는 모든 극장들을 조회 
select distinct ci_th_name from cinema
	join screen on sc_ci_num = ci_num
    join movie on mo_num = sc_mo_num
    join theater on ci_th_name = th_name
    where mo_title = '브로커';
-- CGV청주성안길에서 상영하는 모든 영화 제목들을 조회 
select distinct mo_title from cinema
	join screen on sc_ci_num = ci_num
    join movie on mo_num = sc_mo_num
    where ci_th_name = 'CGV청주성안길';
-- 2022년 6월 14일에 사영하는 모든 영화관과 영화 제목들을 조회         
select distinct ci_th_name, mo_title from cinema
	join screen on sc_ci_num = ci_num
    join movie on mo_num = sc_mo_num
    where sc_start_time like '2022-06-14%';
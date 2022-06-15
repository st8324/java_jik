-- 6/14일 CGV청주성안길에서 11:30에 하는 영화 브로커에 예매 가능한 좌석을 조회(예매된 좌석도 조회)  
select se_name, count(bd_se_num) from seat 
	join (select * from cinema where ci_th_name ='CGV청주성안길' ) as ci 
		on se_ci_num = ci_num
	join (select * from screen where sc_start_time = '2022-06-14 11:30:00' ) as sc 
		on sc_ci_num = ci_num
	join (select * from movie where mo_title ='브로커') as mo 
		on sc_mo_num = mo_num
	left join book on bo_sc_num = sc_num
    left join bookdetail on bo_num = bd_bo_num and bd_se_num = se_num
    where se_use = 'Y'
    group by se_num;

-- 현재 상영중인(개봉이 된) 영화 중 개봉일 기준으로 최신영화 10개를 조회 
select mo_title from movie 
	join screen on sc_mo_num = mo_num
    where sc_start_time >= now() and mo_open_date <= now()
    group by mo_num
	order by mo_open_date desc 
    limit 10;

-- 서울에 있는 모든 영화관 정보를 조회 
select * from theater where th_region = '서울';

-- 예매가 높은 순으로 영화 10개를 조회 
select mo_title as 영화제목, sum(bo_amount) as 예매수 from movie
	join (select * from screen where sc_start_time > now()) as sc 
		on sc_mo_num = mo_num
	join book on bo_sc_num = sc_num
    where bo_state = 'Y'
    group by mo_num
    order by 예매수 desc
    limit 10;

-- CGV에서 영화를 관람한 영화별 관람객수를 조회 
select mo_title as 영화, sum(bo_amount) as 관람객수 from movie
	join (select * from screen where sc_start_time <= now()) as sc 
		on sc_mo_num = mo_num
	join (select * from book where bo_state = 'Y') as bo 
		on bo_sc_num = sc_num
	group by mo_num
    order by 관람객수 desc;        

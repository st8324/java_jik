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
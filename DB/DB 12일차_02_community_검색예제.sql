-- 일반 게시글을 조회 하는데,게시글번호, 게시글제목,댓글수가 조회 
select bd_num, bd_title, count(co_bd_num) from board 
	left join comment on bd_num = co_bd_num
	where bd_ca_name = '일반'
    group by bd_num;

-- 각 카테고리별 게시글 수를 조회 
select ca_name, count(bd_ca_name) from category 
	left join board on ca_name = bd_ca_name
	group by ca_name;
-- case를 이용한 추천,비추천,미추천 표시 
select likes.*,
	case 
		when li_state = 1 then '추천'
		when li_state = -1 then '비추천'
		when li_state = 0 then '미추천' 
	end as 추천여부
from likes;


-- 모든 게시글에 대해 게시글번호, 게시글 제목과 추천수와 비추천수를 조회 
-- 1 제목1	1	0
-- count와 case를 같이 사용 
-- li_state가 1일때 개수를 세는 방법
-- 개수를 세는데 li_state가 1일때 세는 방법
select bd_num as 번호, bd_title as 제목, 
	count(case when li_state = 1 then li_state end) as 추천, 
    count(case when li_state = -1 then li_state end) as 비추천
	from board 
	left join (select * from likes where li_target='board')as li 
		on li_target_num = bd_num
	where bd_ca_name='일반' 
    group by bd_num;

select bd_num as 번호, bd_title as 제목, 
	ifnull(sum(li_state = 1),0) as 추천, 
    ifnull(sum(li_state = -1),0) as 비추천
	from board 
	left join (select * from likes where li_target='board')as li 
		on li_target_num = bd_num
	where bd_ca_name='일반' 
    group by bd_num;

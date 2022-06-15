-- 문의사항 게시글을 최신순으로 조회, 단 답글인 경우 해당 글 밑에 배치 
select * from board where bd_ca_name = '문의사항'
	order by bd_ori_num desc, bd_depth asc;
    
-- 문의사항 게시글 1페이지에 대한 게시글을 조회. 한 페이지당 보여지는 게시글 개수는 2개 
select * from board where bd_ca_name = '문의사항'
	order by bd_ori_num desc, bd_depth asc 
    -- limit 2*(1-1), 2;
    limit 0, 2;
-- 문의사항 게시글 2페이지에 대한 게시글을 조회. 한 페이지당 보여지는 게시글 개수는 2개 
select * from board where bd_ca_name = '문의사항'
	order by bd_ori_num desc, bd_depth asc
    -- limit 2*(3-1), 2;
    limit 2, 2;

-- 1번 게시글의 추천수를 조회
select count(*) as 1번게시글추천수 from likes
	where li_state = 1 and li_target = 'board' and li_target_num = 1;

-- 1번 게시글의 비추천수를 조회
select count(*) as 1번게시글비추천수 from likes
	where li_state = -1 and li_target = 'board' and li_target_num = 1;













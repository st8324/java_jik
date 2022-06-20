-- 1. 처음으로 추천/비추천을 했을 때, 해당 게시글에 추천 또는 비추천을 업데이트하는 트리거 
-- likes 테이블에 insert를 하는 경우 => board 테이블에서 해당 게시글에 대한 추천/비추천을 update
-- 1번 게시글에 추천을 A사용자가 처음으로 함 => 1번 게시글에 추천 수를 1 증가 
drop trigger if exists insert_likes;
delimiter //
create trigger insert_likes after insert on likes
for each row
begin
	-- likes테이블에 추간된 정보에 추천/비추천 
    -- 어떤 테이블에 수를 업데이트할지 
    -- 게시글 번호 
    declare _state int; -- 추천/비추천 
    declare _table varchar(20); -- 테이블명 
    declare _num int; -- 게시글/댓글 번호 
    -- a회원이 1번 게시글에 처음으로 추천을 했다 
    set _state = new.li_state;
    set _table = new.li_target;
    set _num = new.li_target_num;
    
    if _state = 1 and _table like 'board' then
		update board set bd_up = bd_up + 1 where bd_num = _num;
	end if;
    if _state = -1 and _table like 'board' then
		update board set bd_down = bd_down + 1 where bd_num = _num;
	end if;
		
end //
delimiter ;

insert into likes(li_us_id, li_state, li_target, li_target_num)
	values('qwer1234', 1, 'board', 7);
insert into likes(li_us_id, li_state, li_target, li_target_num)
	values('admin123', 1, 'board', 7);
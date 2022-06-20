-- 2. 기존에 해던 추천/비추천을 변경해서 새로 추천/비추천을 하는 경우 업데이트하는 트리거
-- likes 테이블에 update를 하는 경우 
-- => board 테이블에서 변경되기전 추천/비추천의 수를 1감소하고, 변경된 후 추천/비추천의 수를 1 증가 
drop trigger if exists update_likes;
delimiter //
create trigger update_likes after update on likes
for each row
begin
	-- 수정 전 상태가 추천인 경우 
	if old.li_target like 'board' and old.li_state = 1 then
		update board set bd_up = bd_up - 1 where bd_num = old.li_target_num;
    end if;
    -- 수정 전 상태가 비추천인 경우 
	if old.li_target like 'board' and old.li_state = -1 then
		update board set bd_down = bd_down - 1 where bd_num = old.li_target_num;
    end if;
    
    -- 수정 후 상태가 추천인 경우
    if new.li_target like 'board' and new.li_state = 1 then
		update board set bd_up = bd_up + 1 where bd_num = new.li_target_num;
    end if;
    -- 수정 후 상태가 비추천인 경우 
    if new.li_target like 'board' and new.li_state = -1 then
		update board set bd_down = bd_down + 1 where bd_num = new.li_target_num;
    end if;
end //
delimiter ;
update likes set li_state = 0 where li_num = 1; 
-- 위 update를 실행 후, 댓글 1번에 해당하는 board 테이블에 1번 게시글에 추천/비추천수를 확인
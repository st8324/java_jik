-- 예매를 취소할 때 필요한 트리거를 만드세요. 
-- 취소는 예약이 Y-> N
-- 이벤트 : update, 테이블명 : book => 예약 가능한 좌석수를 증가(screen)

drop trigger if exists update_book;

delimiter //
create trigger update_book after update on book
for each row
begin
	-- 상영 정보에서 예약 가능한 좌석을 늘려야함 
    if old.bo_state like 'Y' and new.bo_state like 'N' 
		-- and now() < (select sc_start_time from screen where sc_num = new.bo_sc_num)
    then
		update screen set sc_pos_seat = sc_pos_seat + new.bo_amount 
			where sc_num = new.bo_sc_num;
    end if;
end //
delimiter ;

update book set bo_state = 'N' where bo_num = 3;
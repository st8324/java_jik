-- 예매를 하면 해당 상영 좌석수가 감소하는 트리거를 생성 
-- abc123 회원이 브로커 14:05분 영화를 A1, A2, B1을 예매 했을 때 
-- 브로커 14:05분 상영 좌석이 7로 수정되어야함 
-- 이벤트 : insert, 테이블 : book
-- 100. 2좌석을 예매 => 98좌석 

drop trigger if exists insert_book;
delimiter //
create trigger insert_book after insert on book
for each row
begin
	update screen 
		set 
			sc_pos_seat = sc_pos_seat - new.bo_amount 
        where 
			sc_num = new.bo_sc_num;
end //
delimiter ;

insert into book(bo_us_id, bo_amount, bo_sc_num, bo_total_price, bo_state, bo_date) 
	values('abc123', 3, 2, 30000, 'Y', now());
insert into bookdetail(bd_bo_num, bd_se_num, bd_price)
	values(3, 1, 10000),(3, 2, 10000),(3, 3, 10000);



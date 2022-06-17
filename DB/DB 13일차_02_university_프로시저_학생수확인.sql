-- university에서 현재 등록된 학생수를 알려주는 프로시저를 만들고, 호출해서 확인해보세요. 
-- count_student 
drop procedure if exists count_student;
delimiter // 
create procedure count_student(
	out o_count int
)
begin
	set o_count = (select count(*) from student);
end //
delimiter ;

set @count = 0; -- @count 전역변수 선언 및 초기화
call count_student(@count); -- count_student프로시저를 호출할 때 @count를 넘겨줌 
select @count; -- 프로시저에서 바꾼(학생수) @count값 확인
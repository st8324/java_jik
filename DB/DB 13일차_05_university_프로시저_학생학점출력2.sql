/* 학생들의 총점을 이용하여 학점을 출력하는 프로시저를 작성해보세요. 
90 ~ 100 : A 
80 ~ 89  : B 
70 ~ 79  : C 
60 ~ 69  : D 
0 ~  59  : F 
*/
drop procedure if exists print_score2;
delimiter // 
create procedure print_score2()
begin
	declare i int default 0;
    declare _count int; -- 수강하는 학생들 수 
    declare _num char(10); -- 학생 번호 
    declare _total int; -- 학생 성적 
    declare _grade char(1); -- 학생 학점
    
    set _count = (select count(*) from course);
    while(i < _count) do
		set _num   = (select co_st_num from course limit i,1);
        set _total = (select co_total from course limit i,1);
        if _total >= 90 and _total <= 100 then 
			set _grade = 'A';
		end if;
		if _total >= 80 and _total < 90 then 
			set _grade = 'B';
		end if;
		if _total >= 70 and _total < 80  then 
			set _grade = 'C';
		end if;
		if _total >= 60 and _total < 70  then 
			set _grade = 'D';
		end if;
		if _total >= 0 and _total < 60  then 
			set _grade = 'F';
		end if;
        select _num, _grade;
        set i = i + 1;
    end while;
end //
delimiter ;

call print_score2();
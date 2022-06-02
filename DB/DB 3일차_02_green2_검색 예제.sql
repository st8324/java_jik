use green2;
-- 학부 전체 데이터 확인
select * from green2.학부;
-- 학부명만 확인 
select 학부명 from green2.학부;
-- 컴퓨터공학부의 학부위치를 확인 
select 학부명, 학부위치 from green2.학부 where 학부명 = '컴퓨터공학부';
-- 컴퓨터공학부가 아닌 학부들의 학부위치를 확인 
select 학부명, 학부위치 from green2.학부 where 학부명 != '컴퓨터공학부';
select 학부명, 학부위치 from green2.학부 where 학부명 <> '컴퓨터공학부';

-- insert into 학생 values(1, '홍길동', '컴퓨터공학부'),(2, '고길동', '기계공학부'),
-- (3, '이순신', '전자공학부'),(4, '유관순', '컴퓨터공학부'),(5, '임꺽정', '컴퓨터공학부');

-- 전체 학생 정보를 확인하는 쿼리문 
select * from 학생;
-- 학생번호가 2~4인 학생 정보를 확인하는 쿼리문 (2이상 4이하)
select * from 학생 where 학생번호 >= 2 and 학생번호 <= 4;
select * from 학생 where 학생번호 between 2 and 4;
-- 학생번호가 1 또는 4 또는 5인 학생 정보를 확인하는 쿼리문
select * from 학생 where 학생번호 = 1 or 학생번호 = 4 or 학생번호 = 5;
select * from 학생 where 학생번호 in(1,4,5);
-- 문자열 비교에서 =은 완전히 같은 문자열만 확인 
-- like는 문자열 비교에서 와일드카드와 같이 사용되어 문자열이 포함된 정보들을 확인할 때 사용 
-- like는 like만 있는 경우는 =과 같은 역할을 함 
select * from 학생 where 이름 = '홍길동';
select * from 학생 where 이름 like '홍길동';
-- _ : 한글자를 의미하고, 아무 글자가 와도 됨  
-- 이름이 길동이고, 성이 1글자인 학생을 확인 
select * from 학생 where 이름 like '_길동';
-- % : 0글자 이상을 의미함 
-- 이름 마지막이 길동으로 끝나는 학생을 확인
select * from 학생 where 이름 like '%길동';
-- 성이 홍씨인 학생을 확인 
select * from 학생 where 이름 like '홍%';
-- 이름에 길이 들어가는 학생을 확인 
select * from 학생 where 이름 like '%길%';
-- 이름이 3글자인 학생을 확인
select * from 학생 where 이름 like '___';
-- 컴퓨터공학부 학생이거나 전자공학부 학생을 확인 
select * from 학생 where 학부 = '컴퓨터공학부' or 학부 = '전자공학부';
select * from 학생 where 학부 in('컴퓨터공학부', '전자공학부');


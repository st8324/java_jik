-- 1. 컴퓨터 공학과 학생들(160)을 조회
select * from student where st_num like '____160%';
select * from student where substr(st_num, 5,3) like '160';

-- 2. 대학수학기초 또는 대학영어를 수강하는 학생들을 조회
select * from course 
	join subject on co_su_code = su_code
    join student on co_st_num = st_num
	where su_name in ('대학수학기초', '대학영어');
-- 3. 대학수학기초와 대학영어 모두를 수강하는 학생들을 조회
SELECT 
    st_name
FROM
    course
        JOIN
    subject ON co_su_code = su_code
        JOIN
    student ON co_st_num = st_num
    where su_name in ('대학수학기초' , '대학영어') group by st_num having count(st_num) = 2;
-- 4. 유재석 교수가 강의하는 강좌들을 수강하는 학생들을 조회
select distinct st_num, st_name from course 
	join subject on co_su_code = su_code
    join professor on pr_num = su_pr_num
    join student on st_num = co_st_num
    where pr_name = '유재석';
-- 5. 학과별 학생들 수를 조회
select substr(st_num, 5, 3) as 학과, count(*) as 학생수 from student group by 학과;

-- 6. 2022년에 입학한 학생들을 조회
select 2022 as 입학년도, st_name from student where substr(st_num, 1, 4) like 2022;
select 2022 as 입학년도, st_name from student where st_num like '2022%';

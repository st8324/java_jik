-- 각 강좌별 수강생 수를 조회
select 강좌코드, count(*) as 수강생수 from 수강 group by 강좌코드;
-- 학생별 듣는 강좌 수를 조회 
select 학번, count(*) as 강의수 from 수강 group by 학번;

-- 교수별 강의하는 강의수를 조회
select 교번, count(*) as 강의수 from 강좌 group by 교번;
-- 교수별 지도하는 학생수를 조회 
select 교번, count(*) as 지도학생수 from 학생 group by 교번;
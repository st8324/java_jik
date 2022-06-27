use university;

SELECT 
    *
FROM
    student
WHERE
    SUBSTR(st_num, 5, 3) LIKE '135';

SELECT 
    su_name, st_name
FROM
    course
        JOIN
    subject ON co_su_code = su_code
        JOIN
    student ON st_num = co_st_num
WHERE
    su_name IN ('대학수학기초' , '컴퓨터개론');
    
SELECT 
    su_name, st_name
FROM
    course
        JOIN
    subject ON co_su_code = su_code
        JOIN
    student ON st_num = co_st_num
WHERE
    su_name ='대학수학기초' and su_name ='컴퓨터개론';

SELECT DISTINCT
    st_name
FROM
    student
        JOIN
    course ON st_num = co_st_num
        JOIN
    subject ON co_su_code = su_code
        JOIN
    professor ON pr_num = su_pr_num
WHERE
    pr_name = '강호동';

SELECT 
    SUBSTR(pr_num, 5, 3) AS '학과', COUNT(*) AS '교수수'
FROM
    professor
GROUP BY 학과;

SELECT 
    *
FROM
    professor
WHERE
    pr_num LIKE '2022%';

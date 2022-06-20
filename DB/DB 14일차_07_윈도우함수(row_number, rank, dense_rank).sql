/* 
row_number() : 순서를 세서 1부터 차례대로 숫자를 할당, over()에 있는 것을 기준으로 
순서라는 속성을 하나 만들고(실제 테이블에 속성을 추가하는 것이 아니라 결과화면에 추가), 그 속성값으로 1부터
하나씩 증가하도록 하는데 기준을 over()안에 있는 정렬방법 기준으로 삼음 .
같은 값이 있으면 번호가 다름 
2 < 12
'2' > '12'
*/
-- 일반 게시글을 등록 순서대로 정렬 
SELECT 
    row_number() over(order by bd_num asc)순서 ,board.*
FROM
    community.board
WHERE
    bd_ca_name = '일반';

-- 일반 게시글들을 비추천 순으로 정렬 
/* 
rank()는 row_number()와 다르게 값이 같으면 같은 값을 가지고, 다음 번호는 생략 
dense_rank()는 rank()와 다르게 다음 번호를 생략하지 않음 
*/
SELECT 
    rank() over(order by bd_down desc)순서 ,board.*
FROM
    community.board
WHERE
    bd_ca_name = '일반'
order by bd_down desc, 순서 asc;
SELECT 
    dense_rank() over(order by bd_down desc)순서 ,board.*
FROM
    community.board
WHERE
    bd_ca_name = '일반'
order by bd_down desc, 순서 asc;
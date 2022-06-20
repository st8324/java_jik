-- 기존에 likes 테이블에 있는 데이터들로 추천/비추천수 업데이트 
UPDATE board 
SET 
    bd_up = (SELECT 
            COUNT(*)
        FROM
            likes
        WHERE
            bd_num = li_target_num
                AND li_target = 'board'
                AND li_state = 1),
    bd_down = (SELECT 
            COUNT(*)
        FROM
            likes
        WHERE
            bd_num = li_target_num
                AND li_target = 'board'
                AND li_state = - 1);











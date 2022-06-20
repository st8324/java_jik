-- 상영 영화 예매 가능 좌석 수로 업데이트하는 쿼리문 
UPDATE screen 
SET 
    sc_pos_seat = (SELECT 
            ci_max_seat
        FROM
            cinema
        WHERE
            sc_ci_num = ci_num) - (SELECT 
            IFNULL(SUM(bo_amount), 0)
        FROM
            book
        WHERE
            sc_num = bo_sc_num and bo_state = 'Y');
SELECT * FROM cgv.screen;
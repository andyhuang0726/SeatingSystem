DELIMITER $$

CREATE PROCEDURE assign_seat(
    IN p_emp_id INT,            -- 員工編號
    IN p_floor_seat_seq INT     -- 座位序號 
)
BEGIN
    START TRANSACTION;

    -- 先清空該座位原本的員工
    UPDATE Employee
    SET FLOOR_SEAT_SEQ = NULL
    WHERE FLOOR_SEAT_SEQ = p_floor_seat_seq;

    -- 指派新座位
    UPDATE Employee
    SET FLOOR_SEAT_SEQ = p_floor_seat_seq
    WHERE EMP_ID = p_emp_id;

    COMMIT;
END$$

DELIMITER ;

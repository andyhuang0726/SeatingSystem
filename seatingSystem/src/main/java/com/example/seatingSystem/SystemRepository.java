package com.example.seatingSystem;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SystemRepository {
    private final JdbcTemplate jdbcTemplate;

    // 注入 JdbcTemplate
    public SystemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 呼叫 Stored Procedure 進行座位指派
    public void callAssignSeat(Integer empId, Integer seatSeq) {
        // 使用 ? 參數，避免 SQL Injection
        String sql = "CALL assign_seat(?, ?)";
        jdbcTemplate.update(sql, empId, seatSeq);
    }

    // 查詢所有座位（LEFT JOIN，空位也要顯示）
    public List<Map<String, Object>> findAllSeats() {

        String sql = """
            SELECT
                s.FLOOR_SEAT_SEQ,  -- 座位流水號
                s.FLOOR_NO,        -- 樓層
                s.SEAT_NO,         -- 座位編號
                e.EMP_ID           -- 員工編號
            FROM SeatingChart s
            LEFT JOIN Employee e
            ON s.FLOOR_SEAT_SEQ = e.FLOOR_SEAT_SEQ
            ORDER BY s.FLOOR_NO, s.SEAT_NO
        """;

        // 回傳 List<Map<欄位名稱, 值>>
        return jdbcTemplate.queryForList(sql);
    }
}





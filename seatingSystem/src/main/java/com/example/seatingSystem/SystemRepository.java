package com.example.seatingSystem;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}



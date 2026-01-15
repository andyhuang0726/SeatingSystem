package com.example.seatingSystem;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.seatingSystem.SystemRepository;

import java.util.List;
import java.util.Map;

@Service
public class SystemService {

    private final SystemRepository repository;

    public SystemService(SystemRepository repository) {
        this.repository = repository;
    }

    // 指派座位
    // 使用 Transaction 確保資料一致性
    @Transactional
    public void assignSeat(Integer empId, Integer seatSeq) {
        // 呼叫 Stored Procedure
        repository.callAssignSeat(empId, seatSeq);
    }
    
    // 取得所有座位資訊
    public List<Map<String, Object>> getAllSeats() {
        return repository.findAllSeats();
    }
        
}

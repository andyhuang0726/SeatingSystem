package com.example.seatingSystem;

import org.springframework.web.bind.annotation.*;
import com.example.seatingSystem.SystemService;

@RestController
@RequestMapping("/api/seating")
public class SystemController {
    private final SystemService service;

    public SystemController(SystemService service) {
        this.service = service;
    }

    public List<Map<String, Object>> getAllSeats() {
        // 直接呼叫 Service 層
        return service.getAllSeats();
    }

}


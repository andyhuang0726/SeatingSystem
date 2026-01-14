package com.example.seatingSystem;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.seatingSystem.SystemService;

@RestController
@RequestMapping("/api/seating")
public class SystemController {
    private final SystemService seatingSystemService;

    public SeatingController(SystemService seatingService) {
        this.seatingSystemService = seatingService;
    }

}

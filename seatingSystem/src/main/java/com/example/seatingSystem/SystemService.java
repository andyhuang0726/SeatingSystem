package com.example.seatingSystem;

import org.springframework.stereotype.Service;
import com.example.seatingSystem.SystemRepository;

@Service
public class SystemService {
    private final SystemRepository repository;

    public SystemService(SystemRepository repository) {
        this.repository = repository;
    }
}



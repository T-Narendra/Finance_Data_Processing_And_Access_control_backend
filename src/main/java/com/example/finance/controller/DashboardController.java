package com.example.finance.controller;

import com.example.finance.dto.SummaryDTO;
import com.example.finance.service.DashboardService;
import com.example.finance.util.RoleUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService service;

    public DashboardController(DashboardService service) {
        this.service = service;
    }

    @GetMapping("/summary")
    public SummaryDTO getSummary(@RequestHeader String role) {
        RoleUtil.checkAnalystOrAdmin(role);
        return service.getSummary();
    }
}
package com.example.finance.service;

import com.example.finance.dto.SummaryDTO;
import com.example.finance.entity.Record;
import com.example.finance.entity.Type;
import com.example.finance.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    private final RecordRepository repo;

    public DashboardService(RecordRepository repo) {
        this.repo = repo;
    }

    public SummaryDTO getSummary() {

        List<Record> records = repo.findAll();

        double income = 0;
        double expense = 0;

        for (Record r : records) {
            if (r.getType() == Type.INCOME) {
                income += r.getAmount();
            } else if (r.getType() == Type.EXPENSE) {
                expense += r.getAmount();
            }
        }

        return new SummaryDTO(income, expense, income - expense);
    }
}
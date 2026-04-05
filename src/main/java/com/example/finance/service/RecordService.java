package com.example.finance.service;

import com.example.finance.entity.Record;
import com.example.finance.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    private final RecordRepository repo;

    public RecordService(RecordRepository repo) {
        this.repo = repo;
    }

    public Record create(Record record) {
        return repo.save(record);
    }

    public List<Record> getAll() {
        return repo.findAll();
    }

    public Record update(Long id, Record newRecord) {
        Record record = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        record.setAmount(newRecord.getAmount());
        record.setCategory(newRecord.getCategory());
        record.setType(newRecord.getType());
        record.setDate(newRecord.getDate());

        return repo.save(record);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
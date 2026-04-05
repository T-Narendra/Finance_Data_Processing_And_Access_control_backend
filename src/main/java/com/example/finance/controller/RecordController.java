package com.example.finance.controller;

import com.example.finance.entity.Record;
import com.example.finance.service.RecordService;
import com.example.finance.util.RoleUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordService service;

    public RecordController(RecordService service) {
        this.service = service;
    }

    @PostMapping
    public Record create(@RequestBody Record record, @RequestHeader String role) {
        RoleUtil.checkAdmin(role);
        return service.create(record);
    }

    @GetMapping
    public List<Record> getAll(@RequestHeader String role) {
        RoleUtil.checkAllRoles(role);
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Record update(@PathVariable Long id,
                         @RequestBody Record record,
                         @RequestHeader String role) {
        RoleUtil.checkAdmin(role);
        return service.update(id, record);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id,
                       @RequestHeader String role) {
        RoleUtil.checkAdmin(role);
        service.delete(id);
    }
}
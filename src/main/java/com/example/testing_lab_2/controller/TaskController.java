package com.example.testing_lab_2.controller;

import com.example.testing_lab_2.dto.CreateUpdateTaskDto;
import com.example.testing_lab_2.dto.TaskDto;
import com.example.testing_lab_2.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public TaskDto save(@RequestBody CreateUpdateTaskDto createUpdateTaskDto) {
        return taskService.save(createUpdateTaskDto);
    }
    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable String id) {
        return taskService.getById(id);
    }
    @GetMapping
    public List<TaskDto> getAll() {
        return taskService.getAll();
    }
    @DeleteMapping
    public void deleteAll() {
        taskService.deleteAll();
    }
}

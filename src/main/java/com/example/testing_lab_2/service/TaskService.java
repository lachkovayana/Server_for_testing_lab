package com.example.testing_lab_2.service;

import com.example.testing_lab_2.dto.CreateUpdateTaskDto;
import com.example.testing_lab_2.dto.TaskDto;
import com.example.testing_lab_2.entity.TaskEntity;
import com.example.testing_lab_2.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    @Transactional
    public TaskDto save(CreateUpdateTaskDto createUpdateTaskDto) {
        var entity = new TaskEntity(
                UUID.randomUUID().toString(),
                createUpdateTaskDto.getInput(),
                createUpdateTaskDto.getResult()
        );
        var savedEntity = taskRepository.save(entity);
        return new TaskDto(savedEntity.getUuid(), savedEntity.getInput(), savedEntity.getResult());
    }

    @Transactional(readOnly = true)
    public TaskDto getById(String id) {
        var entity = taskRepository.findById(id).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND)
        );
        return new TaskDto(entity.getUuid(), entity.getInput(), entity.getResult());
    }

    @Transactional(readOnly = true)
    public List<TaskDto> getAll() {
        var entities = taskRepository.findAll();
        var result = new ArrayList<TaskDto>();
        entities.forEach(entity -> result.add(new TaskDto(
                entity.getUuid(),
                entity.getInput(),
                entity.getResult())));
        return result;
    }

    @Transactional
    public void deleteAll() {
        taskRepository.deleteAll();
    }


}

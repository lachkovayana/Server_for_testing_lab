package com.example.testing_lab_2.repository;

import com.example.testing_lab_2.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, String> { }

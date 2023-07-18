package com.cydeo.service;

import com.cydeo.dto.TaskDTO;
import com.cydeo.enums.Status;

import java.util.List;

public interface TaskService {
    TaskDTO getTaskById(Long taskId);
    List<TaskDTO> listAllTasks();
    void save(TaskDTO dto);
    void deleteById(Long taskId);
    void update(TaskDTO task);
    Status findAllTasksByStatusIsNot(Status status);

    void updateStatus(TaskDTO task);

    Status findAllTasksByStatus(Status status);
}

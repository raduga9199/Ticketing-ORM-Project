package com.cydeo.service;

import com.cydeo.dto.TaskDTO;
import com.cydeo.enums.Status;

import java.util.List;

public interface TaskService {

    TaskDTO findById(Long taskId);
    List<TaskDTO> listAllTasks();
    void save(TaskDTO dto);
    void update(TaskDTO task);
    void delete(Long id);

    Status findAllTasksByStatusIsNot(Status status);
    void updateStatus(TaskDTO task);
    Status findAllTasksByStatus(Status status);


}

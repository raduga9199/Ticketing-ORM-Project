package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;
import com.cydeo.enums.Status;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TaskServicesImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskServicesImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskDTO getTaskById(Long taskId) {

        Task task = taskRepository.findTaskById(taskId);
        return taskMapper.convertToDTO(task);
    }

    @Override
    public List<TaskDTO> listAllTasks() {
        List<Task> projectList = taskRepository.findAll();

        return projectList
                .stream()
                .map(taskMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void save(TaskDTO dto) {
        taskRepository.save(taskMapper.convertToEntity(dto));
    }

    @Override
    public void deleteById(Long taskId) {

    }

    @Override
    public void update(TaskDTO task) {

    }

    @Override
    public Status findAllTasksByStatusIsNot(Status status) {
        return Status.COMPLETE;
    }

    @Override
    public void updateStatus(TaskDTO task) {

    }

    @Override
    public Status findAllTasksByStatus(Status status) {
        return Status.COMPLETE;
    }
}

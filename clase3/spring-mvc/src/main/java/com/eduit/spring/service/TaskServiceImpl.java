package com.eduit.spring.service;

import com.eduit.spring.model.Task;
import com.eduit.spring.model.TaskStatus;
import com.eduit.spring.model.mapper.DtoMapper;
import com.eduit.spring.model.dto.TaskDto;
import com.eduit.spring.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    private DtoMapper<TaskDto, Task> dtoToTaskMapper;
    private DtoMapper<Task, TaskDto> taskToDtoMapper;

    public TaskServiceImpl(TaskRepository taskRepository, DtoMapper<TaskDto, Task> dtoToTaskMapper, DtoMapper<Task, TaskDto> taskToDtoMapper) {
        this.taskRepository = taskRepository;
        this.dtoToTaskMapper = dtoToTaskMapper;
        this.taskToDtoMapper = taskToDtoMapper;
    }

    @Override
    public List<TaskDto> getTasks() {
        List<Task> tasks = taskRepository.getTasks();

        EnumMap<TaskStatus, List<TaskDto>> tasksByStatus = new EnumMap<>(TaskStatus.class);



        return taskToDtoMapper.map(tasks);
    }

    @Override
    public void addTask(TaskDto taskDto) {
        Task task = dtoToTaskMapper.map(taskDto);
        taskRepository.addTask(task);
    }
}

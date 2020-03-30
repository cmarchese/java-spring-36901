package com.eduit.spring.service;

import com.eduit.spring.model.dto.TaskDto;

import java.util.List;

public interface TaskService {

    List<TaskDto> getTasks();

    void addTask(TaskDto taskDtoRequest);

}

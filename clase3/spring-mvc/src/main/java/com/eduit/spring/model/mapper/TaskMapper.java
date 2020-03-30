package com.eduit.spring.model.mapper;

import com.eduit.spring.model.Task;
import com.eduit.spring.model.dto.TaskDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper implements DtoMapper<Task, TaskDto> {

    @Override
    public TaskDto map(Task task) {
        return new TaskDto(
                task.getTitle(),
                task.getDescription(),
                task.getDueDate().toString()
        );
    }

    @Override
    public List<TaskDto> map(List<Task> tasks) {
        return tasks.stream().map(task ->
                new TaskDto(task.getTitle(), task.getDescription(), task.getDueDate().toString())).collect(Collectors.toList());
    }
}

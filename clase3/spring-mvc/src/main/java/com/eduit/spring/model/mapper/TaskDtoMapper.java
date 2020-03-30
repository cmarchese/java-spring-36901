package com.eduit.spring.model.mapper;

import com.eduit.spring.model.Task;
import com.eduit.spring.model.dto.TaskDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskDtoMapper implements DtoMapper<TaskDto, Task> {

    @Override
    public Task map(TaskDto taskDto) {
        return new Task(
                taskDto.getTitle(),
                taskDto.getDescription(),
                LocalDateTime.parse(taskDto.getDueDate())
        );
    }

    @Override
    public List<Task> map(List<TaskDto> taskDtoList) {
        return taskDtoList.stream().map(task ->
                new Task(task.getTitle(), task.getDescription(), LocalDateTime.parse(task.getDueDate()))).collect(Collectors.toList());
    }
}

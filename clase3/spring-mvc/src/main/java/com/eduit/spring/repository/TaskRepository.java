package com.eduit.spring.repository;

import com.eduit.spring.model.Task;

import java.util.List;

public interface TaskRepository {

    List<Task> getTasks();

    void addTask(Task task);
}

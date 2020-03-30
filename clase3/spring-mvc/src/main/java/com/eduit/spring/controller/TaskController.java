package com.eduit.spring.controller;

import com.eduit.spring.model.dto.TaskDto;
import com.eduit.spring.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/")
    public String home(Model model) {

        model.addAttribute("tasks", taskService.getTasks());

        return "home";
    }

    @PostMapping(value = "/task/add")
    public String saveTask(@ModelAttribute("task") TaskDto task, BindingResult result, Model model) {
        taskService.addTask(task);

        model.addAttribute("task", task);

        return "redirect:/";
    }

    @ModelAttribute("task")
    public TaskDto formBackingObject() {
        return new TaskDto();
    }
}

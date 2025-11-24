package com.taskflow.taskflow.controller;

import com.taskflow.taskflow.model.Task;
import com.taskflow.taskflow.model.User;
import com.taskflow.taskflow.repository.TaskRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getTasks(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return taskRepository.findByUser(user);
    }

    @PostMapping
    public Task addTask(@RequestBody Task task, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        task.setUser(user);
        return taskRepository.save(task);
    }
}

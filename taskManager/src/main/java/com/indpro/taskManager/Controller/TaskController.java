package com.indpro.taskManager.Controller;


import com.indpro.taskManager.DTO.TaskDto;
import com.indpro.taskManager.Entity.Task;
import com.indpro.taskManager.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public Task createTask(
            @RequestBody TaskDto request){

        return taskService.createTask(request);
    }

    @GetMapping("/{userId}")
    public List<Task> getTasks(
            @PathVariable Long userId){

        return taskService.getTasksByUser(userId);
    }

    @PutMapping("/{id}")
    public Task updateTask(
            @PathVariable Long id,
            @RequestBody TaskDto request){

        return taskService.updateTask(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(
            @PathVariable Long id){

        return taskService.deleteTask(id);
    }
}

package com.indpro.taskManager.Service;


import com.indpro.taskManager.DTO.TaskDto;
import com.indpro.taskManager.Entity.Task;
import com.indpro.taskManager.Entity.User;
import com.indpro.taskManager.Repository.TaskRepo;
import com.indpro.taskManager.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepo taskRepository;
    private final UserRepo userRepository;

    public Task createTask(TaskDto request) {

        User user = userRepository
                .findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setUser(user);

        return taskRepository.save(task);
    }

    public List<Task> getTasksByUser(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public Task updateTask(Long id, TaskDto request) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());

        return taskRepository.save(task);
    }

    public String deleteTask(Long id) {

        taskRepository.deleteById(id);

        return "Task Deleted Successfully";
    }
}

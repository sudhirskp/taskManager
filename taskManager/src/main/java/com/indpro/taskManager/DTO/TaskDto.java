package com.indpro.taskManager.DTO;


import com.indpro.taskManager.Entity.TaskStatus;
import lombok.Data;

@Data
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private Long userId;
}

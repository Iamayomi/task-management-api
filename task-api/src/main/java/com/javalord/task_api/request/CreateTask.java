package com.javalord.task_api.request;

import com.javalord.task_api.constant.TaskStatus;
import lombok.Data;

@Data
public class CreateTask {
    private int id;
    private String title;
    private String description;
    private TaskStatus status;
    private int userId;
}

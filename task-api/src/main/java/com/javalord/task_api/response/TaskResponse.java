package com.javalord.task_api.response;

import com.javalord.task_api.constant.TaskStatus;

import lombok.Data;

@Data
public class TaskResponse {
    private int id;
    private String title;
    private String description;
    private TaskStatus status;
    private int userId;
}

package com.javalord.task_api.service;

import com.javalord.task_api.entity.Task;
import com.javalord.task_api.request.CreateTask;
import com.javalord.task_api.request.UpdateTaskStatus;

import java.util.List;

public interface TaskService {

    Task create(CreateTask request);

    List<Task> findAllTaskByUser(int id);

    Task updateTaskById(int id, UpdateTaskStatus newStatus);
}

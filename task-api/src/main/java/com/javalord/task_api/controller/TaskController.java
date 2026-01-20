package com.javalord.task_api.controller;

import com.javalord.task_api.constant.ResponseStatus;
import com.javalord.task_api.entity.Task;
import com.javalord.task_api.request.CreateTask;
import com.javalord.task_api.request.UpdateTaskStatus;
import com.javalord.task_api.response.ApiResponse;
import com.javalord.task_api.response.TaskResponse;
import com.javalord.task_api.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class TaskController {

    private final TaskService taskService;
    private final ModelMapper modelMapper;

    @PostMapping(value = "/tasks")
    public ResponseEntity<?> create(@RequestBody @Valid CreateTask request) {
        Task task = taskService.create(request);
        ApiResponse<Task> response = new ApiResponse<>(ResponseStatus.CREATED.name(), task);

        return ResponseEntity
                .created(URI.create("/tasks"))
                .body(response);
    }

    @GetMapping(value = "/users/{id}/tasks")
    public ResponseEntity<?> findAllTaskByUser(@PathVariable(value = "id") int id) {
        List<Task> taskList = taskService.findAllTaskByUser(id);

        List<TaskResponse> taskResponses = modelMapper.map(taskList, new TypeToken<List<TaskResponse>>() {}.getType());

        ApiResponse<List<TaskResponse>> response = new ApiResponse<>(ResponseStatus.SUCCESS.name(), taskResponses);

        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/tasks/{id}/status")
    public ResponseEntity<?> updateTaskById(
            @RequestBody UpdateTaskStatus newStatus,
            @PathVariable(value = "id") int id
    ) {
        Task task = taskService.updateTaskById(id, newStatus);
        TaskResponse taskResponse = modelMapper.map(task, TaskResponse.class);

        ApiResponse<TaskResponse> response = new ApiResponse<>(ResponseStatus.UPDATED.name(), taskResponse);


        return ResponseEntity
                .ok(response);
    }
}

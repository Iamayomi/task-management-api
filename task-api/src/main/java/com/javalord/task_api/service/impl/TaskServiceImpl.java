package com.javalord.task_api.service.impl;

import com.javalord.task_api.constant.ErrorMessage;
import com.javalord.task_api.entity.Task;
import com.javalord.task_api.entity.User;
import com.javalord.task_api.exception.ResourceNotFoundException;
import com.javalord.task_api.repository.TaskRepository;
import com.javalord.task_api.repository.UserRepository;
import com.javalord.task_api.request.CreateTask;
import com.javalord.task_api.request.UpdateTaskStatus;
import com.javalord.task_api.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public Task create(CreateTask request) {
        Task newTask = modelMapper.map(request, Task.class);

        return taskRepository.save(newTask);
    }

    @Override
    public List<Task> findAllTaskByUser(int id) {
        Optional<User> checkUser = userRepository.findById(id);

        if (checkUser.isEmpty()) {
            throw new ResourceNotFoundException(ErrorMessage.USER_NOT_FOUND);
        }

        return taskRepository.findAllTaskByUserId(id);
    }

    @Override
    public Task updateTaskById(int id, UpdateTaskStatus newStatus) {
        Optional<Task> checkTask = taskRepository.findById(id);

        if (checkTask.isEmpty()) {
            throw new ResourceNotFoundException(ErrorMessage.TASK_NOT_FOUND);
        }

        Task taskToBeUpdated = checkTask.get();
        taskToBeUpdated.setStatus(newStatus.getTaskStatus());

        return taskRepository.save(taskToBeUpdated);
    }
}

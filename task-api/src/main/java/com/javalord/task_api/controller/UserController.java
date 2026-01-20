package com.javalord.task_api.controller;

import com.javalord.task_api.constant.ResponseStatus;
import com.javalord.task_api.entity.User;
import com.javalord.task_api.request.UserCreate;
import com.javalord.task_api.response.ApiResponse;
import com.javalord.task_api.response.UserResponse;
import com.javalord.task_api.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UserCreate request) {
        User user = userService.create(request);

        UserResponse userResponse = modelMapper.map(user, UserResponse.class);

        ApiResponse<UserResponse> response = new ApiResponse<>(ResponseStatus.CREATED.name(), userResponse);


        return ResponseEntity
                .created(URI.create("/users"))
                .body(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") int id) {
        User user = userService.findById(id);

        UserResponse userResponse = modelMapper.map(user, UserResponse.class);

        ApiResponse<UserResponse> response = new ApiResponse<>(ResponseStatus.SUCCESS.name(), userResponse);

        return ResponseEntity.ok(response);
    }
}

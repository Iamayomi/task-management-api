package com.javalord.task_api.service;

import com.javalord.task_api.request.UserCreate;
import com.javalord.task_api.entity.User;

public interface UserService {

    User create(UserCreate request);

    User findById(int id);
}

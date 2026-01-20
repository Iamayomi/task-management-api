package com.javalord.task_api.service.impl;

import com.javalord.task_api.constant.ErrorMessage;
import com.javalord.task_api.exception.ResourceAlreadyExistException;
import com.javalord.task_api.exception.ResourceNotFoundException;
import com.javalord.task_api.repository.UserRepository;
import com.javalord.task_api.request.UserCreate;
import com.javalord.task_api.service.UserService;
import com.javalord.task_api.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public User create(UserCreate request) {
        Optional<User> checkExistingUser = userRepository.findByEmail(request.getEmail());

        if (checkExistingUser.isPresent()) {
            throw new ResourceAlreadyExistException(ErrorMessage.EXISTING_USER_WITH_EMAIL);
        }

        User createUser = modelMapper.map(request, User.class);

        return userRepository.save(createUser);
    }

    @Override
    public User findById(int id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new ResourceNotFoundException(ErrorMessage.USER_NOT_FOUND);
        }

        return userOptional.get();
    }


}

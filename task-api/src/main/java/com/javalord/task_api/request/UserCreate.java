package com.javalord.task_api.request;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserCreate {
    private String name;
    @Email(message = "Email must be a valid one.")
    private String email;
}

package com.javalord.task_api.request;

import com.javalord.task_api.constant.TaskStatus;
import lombok.Data;

@Data
public class UpdateTaskStatus {

    private TaskStatus taskStatus;
}

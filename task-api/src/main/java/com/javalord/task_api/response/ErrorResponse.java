package com.javalord.task_api.response;

import java.time.LocalDate;

public record ErrorResponse(int status, String message, LocalDate timestamp) {}

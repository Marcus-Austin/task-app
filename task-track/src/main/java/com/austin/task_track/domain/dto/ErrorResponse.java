package com.austin.task_track.domain.dto;

public record ErrorResponse(
    int status,
    String message,
    String details
) {
}

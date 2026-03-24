package com.austin.task_track.mappers;

import com.austin.task_track.domain.dto.TaskDto;
import com.austin.task_track.domain.entity.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}

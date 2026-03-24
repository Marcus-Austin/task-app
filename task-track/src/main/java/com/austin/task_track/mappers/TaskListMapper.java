package com.austin.task_track.mappers;

import com.austin.task_track.domain.dto.TaskListDto;
import com.austin.task_track.domain.entity.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);
}

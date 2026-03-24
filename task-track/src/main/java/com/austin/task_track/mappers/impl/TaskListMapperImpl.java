package com.austin.task_track.mappers.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.austin.task_track.domain.dto.TaskListDto;
import com.austin.task_track.domain.entity.Task;
import com.austin.task_track.domain.entity.TaskList;
import com.austin.task_track.domain.entity.TaskStatus;
import com.austin.task_track.mappers.TaskListMapper;
import com.austin.task_track.mappers.TaskMapper;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Component
public class TaskListMapperImpl implements TaskListMapper{

    private final TaskMapper taskMapper;
    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        return new TaskList(
            taskListDto.id(),
            taskListDto.title(),
            taskListDto.description(),
            Optional.ofNullable( taskListDto.tasks())
            .map(tasks -> tasks.stream()
            .map(taskMapper::fromDto)
            .toList()
            ).orElse(null),
   null,
   null
        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        return new TaskListDto(
            taskList.getId(),
            taskList.getTitle(),
            taskList.getDescription(),
            Optional.ofNullable(taskList.getTasks())
            .map(List::size)
            .orElse(0),
            calculateTaskListProgress(taskList.getTasks()),
            Optional.ofNullable(taskList.getTasks()).
            map(tasks -> 
                tasks.stream().map(taskMapper::toDto).toList()
            ).orElse(null)
        );
    }

   private Double calculateTaskListProgress(List<Task> tasks){
    if(null == tasks){
        return null;
    }
    long closedTaskCount = tasks.stream().filter(task ->
        TaskStatus.CLOSED == task.getStatus()
        
    ).count();
    return (double) closedTaskCount / tasks.size();
   }
    
}

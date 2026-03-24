package com.austin.task_track.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.austin.task_track.domain.dto.TaskDto;
import com.austin.task_track.domain.entity.Task;
import com.austin.task_track.mappers.TaskMapper;
import com.austin.task_track.service.TaskService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/task-list/{task_list_id}/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @GetMapping
    public List<TaskDto> listTask(@PathVariable("task_list_id") UUID taskListId) {
        return taskService.listTasks(taskListId)
        .stream()
        .map(taskMapper::toDto)
        .toList();
    }

    @PostMapping
    public TaskDto createTask(
    @PathVariable("task_list_id") UUID taskListId,
    @RequestBody TaskDto taskDto) {
        Task createdTask = taskService.createTask(taskListId,
        taskMapper.fromDto(taskDto));
        return taskMapper.toDto(createdTask);
    }
    
    @GetMapping("/{task_id}")
    public Optional<TaskDto> getTask(
         @PathVariable("task_list_id") UUID taskListId,
          @PathVariable("task_id") UUID taskId
    ) {
        return taskService.getTask(taskListId,taskId).map(taskMapper::toDto);
    }
    
    @PutMapping("/{task_id}")
    public TaskDto updateTask(
          @PathVariable("task_list_id") UUID taskListId,
          @PathVariable("task_id") UUID taskId,
          @RequestBody TaskDto taskDto) {
           Task updatedTask = taskService.updatedTask(
            taskListId,
            taskId,
            taskMapper.fromDto(taskDto)
           );
           return taskMapper.toDto(updatedTask);
    }

    @DeleteMapping
    public void deleteTask(
        @PathVariable("task_list_id") UUID taskListId,
          @PathVariable("task_id") UUID taskId){
            taskService.deleteTask(taskListId,taskId);
    }
}

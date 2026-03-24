package com.austin.task_track.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.austin.task_track.domain.entity.Task;
import com.austin.task_track.domain.entity.TaskList;
import com.austin.task_track.domain.entity.TaskPriority;
import com.austin.task_track.domain.entity.TaskStatus;
import com.austin.task_track.repository.TaskListRepository;
import com.austin.task_track.repository.TaskRepository;
import com.austin.task_track.service.TaskService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;
    

    @Override
    public List<Task> listTasks(UUID taskListId) {
        return taskRepository.findByTaskListId(taskListId);
    }


    @Override
    public Task createTask(UUID taskListId, Task task) {

       if(null != task.getId()){
        throw new IllegalArgumentException("Task already has an id ");
       }
       if(null == task.getTitle() || task.getTitle().isBlank()){
        throw new IllegalArgumentException("Task  title must be present ");
       }
    
    TaskPriority taskPriority = Optional.ofNullable(task.getPriority())
    .orElse(TaskPriority.MEDIUM);

    TaskStatus taskStatus = TaskStatus.OPEN;

    TaskList taskList = taskListRepository.findById(taskListId)
    .orElseThrow(()-> new IllegalArgumentException("Invalid Task List Id provided"));

    LocalDateTime now = LocalDateTime.now();

    Task taskToSave = new  Task(
        null,
        task.getTitle(),
        task.getDescription(),
        task.getDueDate(),
        taskStatus,
        taskPriority,
        taskList,
        now,
        now
    );
    return taskRepository.save(taskToSave);
}


    @Override
    public Optional<Task> getTask(UUID taskListId, UUID taskId) {
       return taskRepository.findByTaskListIdAndid(taskListId,taskId);
    }


    @Override
    public Task updatedTask(UUID taskListId, UUID taskId, Task task) {
      if(null == task.getId()){
        throw new IllegalArgumentException("Task must have an id ");
       }   
       if(!Objects.equals(task.getId(), taskId)){
        throw new IllegalArgumentException(" Task  Id do not match");
       }
       if(null == task.getPriority()){
        throw new IllegalArgumentException("task must hava a valid priority");
       }
       if(null == task.getStatus()){
        throw new IllegalArgumentException("task must have a valid status");
       }

       Task existingTask = taskRepository.findByTaskListIdAndid(taskListId, taskId)
       .orElseThrow(()-> new IllegalArgumentException("task not found"));

       existingTask.setTitle(task.getTitle());
       existingTask.setDescription(task.getDescription());
       existingTask.setDueDate(task.getDueDate());
       existingTask.setPriority(task.getPriority());
       existingTask.setStatus(task.getStatus());
       existingTask.setUpdated(LocalDateTime.now());

       return taskRepository.save(existingTask);
    }



    @Override
    @Transactional
    public void deleteTask(UUID taskListId, UUID taskId) {
       taskRepository.deleteByTaskListIdAndid( taskListId,taskId);
    }

    
}

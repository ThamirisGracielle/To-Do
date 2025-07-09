package thamiris.gracielle.todo.service;

import org.springframework.stereotype.Service;
import thamiris.gracielle.todo.DTO.NewTaskDto;
import thamiris.gracielle.todo.DTO.TaskDto;
import thamiris.gracielle.todo.model.Task;


import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final AtomicLong contadorId = new AtomicLong(1);


    public Task create (NewTaskDto newTaskDto){

        Task newTask = new Task();
        newTask.setId(contadorId.getAndIncrement());
        newTask.setTitle(newTaskDto.getTitulo());
        newTask.setDescription(newTaskDto.getDescription());
        newTask.setDateCreation(LocalDateTime.now());
        newTask.setStatus(Task.Status.PENDENTE);

        return newTask;

    }
}

package thamiris.gracielle.todo.service;

import org.springframework.stereotype.Service;
import thamiris.gracielle.todo.DTO.NewTaskDto;
import thamiris.gracielle.todo.model.Task;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final AtomicLong contadorId = new AtomicLong(1);
    private final Map<Long, Task> listTask = new ConcurrentHashMap<>();


    public Task create (NewTaskDto newTaskDto){

        Task newTask = new Task();
        newTask.setId(contadorId.getAndIncrement());
        newTask.setTitle(newTaskDto.getTitulo());
        newTask.setDescription(newTaskDto.getDescription());
        newTask.setDateCreation(LocalDateTime.now());
        newTask.setStatus(Task.Status.PENDENTE);
        listTask.put(newTask.getId(),newTask);

        return newTask;

    }

    public List<Task> listALL(){
        return new ArrayList<>(listTask.values());
    }

    public Task listById(Long id){
        return listALL()
                        .stream()
                        .filter(t -> t.getId().equals(id))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Id não encontrado"));

    }

    public List<Task> listStatus(Task.Status status) {
        return listALL()
                .stream()
                .filter(t -> t.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public Task update(Long id, NewTaskDto dto){
        Task task = listById(id);

        task.setTitle(dto.getTitulo());
        task.setDescription(dto.getDescription());

        listTask.put(id, task);

        return  task;

    }

    public void delete(Long id) {
        Task task = listById(id);
        listTask.remove(id);
    }
}

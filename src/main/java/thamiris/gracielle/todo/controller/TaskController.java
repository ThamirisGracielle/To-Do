package thamiris.gracielle.todo.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import thamiris.gracielle.todo.DTO.NewTaskDto;
import thamiris.gracielle.todo.model.Task;
import thamiris.gracielle.todo.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {

        this.taskService = taskService;
    }


    @PostMapping
    public ResponseEntity <Task> createTask(@RequestBody NewTaskDto newTaskDto){
        Task createTask = taskService.create(newTaskDto);
        return ResponseEntity.ok(createTask);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable Long id){
        Task task = taskService.listById(id);
        return  ResponseEntity.ok(task);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getByStatus(@PathVariable Task.Status status) {
        List<Task> tasks = taskService.listStatus(status);
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody NewTaskDto newTaskDto){
        taskService.update(id, newTaskDto);
        return ResponseEntity.ok("Tarefa atualizada com sucesso");

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

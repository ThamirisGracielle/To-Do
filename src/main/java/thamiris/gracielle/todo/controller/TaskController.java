package thamiris.gracielle.todo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thamiris.gracielle.todo.DTO.NewTaskDto;
import thamiris.gracielle.todo.model.Task;
import thamiris.gracielle.todo.service.TaskService;

@RestController
@RequestMapping("/tarefa")
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping
    public Task createTask(@RequestBody NewTaskDto newTaskDto){
        return  taskService.create(newTaskDto);

    }
}

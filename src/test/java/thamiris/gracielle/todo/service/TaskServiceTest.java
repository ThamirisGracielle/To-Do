package thamiris.gracielle.todo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import thamiris.gracielle.todo.DTO.NewTaskDto;
import thamiris.gracielle.todo.model.Task;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    void setUp(){
        taskService = new TaskService();
    }

    @Test
    void createTaskSuccessfully(){
        NewTaskDto dto = new NewTaskDto("Estudar", "Revisar Testes unitários");
        Task task = taskService.create(dto);

        Assertions.assertNotNull(task.getId());
        Assertions.assertEquals("Estudar",task.getTitle());
        Assertions.assertEquals("Revisar Testes unitários", task.getDescription());

    }

    @Test
    void returnAllSucessfuly(){
        taskService.create(new NewTaskDto("1","Tarefa 1"));
        taskService.create(new NewTaskDto("2","Tarefa 2"));

        List<Task> listAll = taskService.listALL();

        Assertions.assertEquals(2, listAll.size());


    }

}
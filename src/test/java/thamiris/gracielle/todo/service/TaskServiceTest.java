package thamiris.gracielle.todo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import thamiris.gracielle.todo.DTO.NewTaskDto;
import thamiris.gracielle.todo.model.Task;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
        assertEquals("Estudar",task.getTitle());
        assertEquals("Revisar Testes unitários", task.getDescription());

    }

    @Test
    void returnAllSucessfuly(){
        taskService.create(new NewTaskDto("1","Tarefa 1"));
        taskService.create(new NewTaskDto("2","Tarefa 2"));

        List<Task> listAll = taskService.listALL();

        assertEquals(2, listAll.size());


    }
    @Test
    void deveRetornarTarefaPorId() {
        Task task = taskService.create(new NewTaskDto("Teste", "Desc"));
        Task found = taskService.listById(task.getId());

        assertEquals(task.getTitle(), found.getTitle());
    }

    @Test
    void deveLancarExcecaoQuandoIdNaoExiste() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            taskService.listById(999L);
        });

        assertEquals("Id não encontrado", exception.getMessage());
    }


    @Test
    void deveAtualizarTituloEDescricao() {
        Task task = taskService.create(new NewTaskDto("Antigo", "Desc"));

        NewTaskDto dtoAtualizado = new NewTaskDto("Novo", "Nova desc");
        Task atualizado = taskService.update(task.getId(), dtoAtualizado);

        assertEquals("Novo", atualizado.getTitle());
        assertEquals("Nova desc", atualizado.getDescription());
    }

    @Test
    void deveExcluirTarefaPorId() {
        Task task = taskService.create(new NewTaskDto("Excluir", "Desc"));

        taskService.delete(task.getId());

        assertThrows(RuntimeException.class, () -> taskService.listById(task.getId()));
    }
}
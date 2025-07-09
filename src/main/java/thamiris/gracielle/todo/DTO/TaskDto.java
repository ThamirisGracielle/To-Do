package thamiris.gracielle.todo.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import thamiris.gracielle.todo.model.Task;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class TaskDto  {

    private String titulo;
    private String description;
    private Task.Status status;
}

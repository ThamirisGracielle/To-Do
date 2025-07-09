package thamiris.gracielle.todo.DTO;


import lombok.*;
import thamiris.gracielle.todo.model.Task;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto  {

    private String titulo;
    private String description;
    private Task.Status status;



}

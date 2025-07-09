package thamiris.gracielle.todo.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    private int id;
    private String titulo;
    private String description;
    private LocalDateTime dateCreation;
    private Status status;


    public enum Status{

        COMPLETED,
        PENDING,

    }
}

package thamiris.gracielle.todo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    private Long id;
    private String title;
    private String description;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dateCreation;
    private Status status;

    public enum Status {
        CONCLUIDO,
        PENDENTE,
    }


}

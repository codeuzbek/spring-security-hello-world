package dasturlash.uz.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class TaskDTO {
    private String id;
    private String title;
    private String content;
    private LocalDateTime createdDate;

    public TaskDTO() {
    }

    public TaskDTO(String id, String title, String content, LocalDateTime createdDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
    }
}

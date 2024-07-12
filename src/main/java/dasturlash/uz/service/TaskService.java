package dasturlash.uz.service;

import dasturlash.uz.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    private List<TaskDTO> taskList;

    public TaskService() {
        taskList = new LinkedList<>();

        TaskDTO task1 = new TaskDTO();
        task1.setId(UUID.randomUUID().toString());
        task1.setTitle("Bozor");
        task1.setContent("Bozorga borib meva-chevalar olib kelish kerak.");
        task1.setCreatedDate(LocalDateTime.now());
        taskList.add(task1);

        TaskDTO task2 = new TaskDTO();
        task2.setId(UUID.randomUUID().toString());
        task2.setTitle("Spring Security");
        task2.setContent("Dasturlash.uz ga kirib Spring Securityni o'rganishim kerak.");
        task2.setCreatedDate(LocalDateTime.now());
        taskList.add(task2);
    }

    public TaskDTO create(TaskDTO dto) {
        dto.setId(UUID.randomUUID().toString());
        dto.setCreatedDate(LocalDateTime.now());
        taskList.add(dto);
        return dto;
    }

    public List<TaskDTO> getAll() {
        return taskList;
    }

    public TaskDTO getById(String id) {
        for (TaskDTO dto : taskList) {
            if (dto.getId().equals(id)) {
                return dto;
            }
        }
        return null;
    }

    public Boolean update(TaskDTO dto, String id) {
        TaskDTO exists = getById(id);

        if (exists == null) {
            return false;
        }

        exists.setTitle(dto.getTitle());
        exists.setContent(dto.getContent());
        return true;
    }

    public Boolean delete(String id) {
        return taskList.removeIf(taskDTO -> taskDTO.getId().equals(id));
    }
}

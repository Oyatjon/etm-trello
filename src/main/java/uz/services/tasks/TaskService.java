package uz.services.tasks;

import uz.dtos.task.TaskCreateDto;
import uz.dtos.task.TaskDto;
import uz.repository.tasks.TaskRepository;
import uz.response.Data;
import uz.response.ResponseEntity;
import uz.services.BaseGenericService;
import uz.services.BaseService;

/**
 * @author : Oyatjon  -> @data : 12:11
 */

public class TaskService extends BaseService<TaskRepository, TaskCreateDto, TaskDto,Long>
        implements BaseGenericService {
    public TaskService(TaskRepository repository) {
        super(repository);
    }


    @Override
    public ResponseEntity<Data<Long>> create(TaskCreateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<TaskDto> get(Long id) {
        return null;
    }
}

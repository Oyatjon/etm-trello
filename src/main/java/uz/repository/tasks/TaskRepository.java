package uz.repository.tasks;

import uz.container.UNIContainer;
import uz.property.DatabaseProperties;
import uz.repository.BaseRepository;

/**
 * @author : Oyatjon  -> @data : 12:32
 */

public class TaskRepository extends BaseRepository {
    DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);


}

package uz.repository.comment;

import uz.container.UNIContainer;
import uz.property.DatabaseProperties;
import uz.repository.BaseRepository;

/**
 * @author : Oyatjon  -> @data : 03:20
 */

public class CommentRepository extends BaseRepository {
    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);
}

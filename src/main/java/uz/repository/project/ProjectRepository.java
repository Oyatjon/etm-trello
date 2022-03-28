package uz.repository.project;

import uz.container.UNIContainer;
import uz.dtos.project.ProjectCreateDto;
import uz.property.DatabaseProperties;
import uz.repository.BaseRepository;
import uz.security.SecurityHolder;

import java.sql.Types;

import static uz.utils.BaseUtils.gson;

/**
 * @author : Oyatjon  -> @data : 03:08
 */

public class ProjectRepository  extends BaseRepository {
    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);

    public Long create(ProjectCreateDto dto) {
        String dataParam = gson.toJson(dto);
        prepareArguments(dataParam, SecurityHolder.session.getId());
        return (Long) callProcedure(property.get("prj.create"), Types.BIGINT);
    }
}

package uz.repository.column;

import uz.container.UNIContainer;
import uz.dtos.column.ColumnCreateDto;
import uz.property.DatabaseProperties;
import uz.repository.BaseRepository;
import uz.security.SecurityHolder;
import uz.services.BaseService;

import java.sql.Types;

import static uz.utils.BaseUtils.gson;

/**
 * @author : Oyatjon  -> @data : 06:04
 */

public class ColumnRepository extends BaseRepository {
    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);


    public Long create(ColumnCreateDto dto) {
        String dataParam =gson.toJson(dto);
        prepareArguments(dataParam, SecurityHolder.session.getId());
        return  (Long) callProcedure(property.get("column.create"), Types.BIGINT);

    }
}

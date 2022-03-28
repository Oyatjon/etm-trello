package uz.repository.organization;

import uz.container.UNIContainer;
import uz.dtos.organization.OrgCreateDto;
import uz.dtos.organization.OrgUpdateDto;
import uz.property.DatabaseProperties;
import uz.repository.BaseRepository;
import uz.security.SecurityHolder;


import java.sql.Types;

import static uz.utils.BaseUtils.gson;

/**
 * @author : Oyatjon  -> @data : 11:58
 */

public class OrgRepository extends BaseRepository {
    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);
    public Long create(OrgCreateDto dto){
        String dataParam = gson.toJson(dto);
        prepareArguments(dataParam, SecurityHolder.session.getId());
        return (Long) callProcedure(property.get("org.create"), Types.BIGINT);
    }

    public Boolean updateOrg(OrgUpdateDto dto) {
        String dataParam = gson.toJson(dto);
        prepareArguments(dataParam,SecurityHolder.session.getId());
        return (Boolean) callProcedure(property.get("org.update"),Types.BOOLEAN);
    }

    public void blockOrg(Integer id) {
       prepareArguments(id,SecurityHolder.session.getId());
       callProcedure(property.get("org.block"), -1);

    }

    public void unBlockOrg(Integer id) {
        prepareArguments(id,SecurityHolder.session.getId());
        callProcedure(property.get("org.unBlock"),Types.BOOLEAN);
    }

    public void deleteOrg(Integer id) {
        prepareArguments(id,SecurityHolder.session.getId());
        callProcedure(property.get("org.delete"),Types.BOOLEAN);
    }
}

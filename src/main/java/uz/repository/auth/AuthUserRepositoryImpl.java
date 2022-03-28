package uz.repository.auth;

import uz.container.UNIContainer;
import uz.dtos.auth.AuthUserCreateDto;
import uz.dtos.auth.AuthUserUpdateDto;
import uz.property.DatabaseProperties;
import uz.repository.BaseRepository;
import uz.security.SecurityHolder;
import uz.security.SessionUser;
import uz.services.projectList.ProjectList;

import java.sql.Types;

import static uz.utils.BaseUtils.gson;


/**
 * @author : Oyatjon  -> @data : 00:21
 */

public class AuthUserRepositoryImpl extends BaseRepository {
    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);

    public SessionUser login(String userName, String password) {
        prepareArguments(userName, password);
        String jsonData = (String) callProcedure(property.get("auth.login"), Types.VARCHAR);
        return gson.fromJson(jsonData, SessionUser.class);
    }

    public Long create(AuthUserCreateDto dto) {
        String dataParam = gson.toJson(dto);
        prepareArguments(dataParam, SecurityHolder.session.getId());
        return (Long) callProcedure(property.get("auth.create"), Types.BIGINT);
    }

    public Long updateUser(AuthUserUpdateDto dto) {
        String dataParam = gson.toJson(dto);
        prepareArguments(dataParam, SecurityHolder.session.getId());
        return (Long) callProcedure(property.get("auth.update"), Types.BIGINT);
    }

    public ProjectList prjList(Long projectId, Long id) {
        prepareArguments(projectId, id);
        String jsonData = (String) callProcedure(property.get("prj.list"), Types.VARCHAR);
        return gson.fromJson(jsonData, ProjectList.class);
    }
}

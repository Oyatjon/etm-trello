package uz.services.auth;

import uz.dtos.auth.AuthUserCreateDto;
import uz.dtos.auth.AuthUserDto;
import uz.dtos.auth.AuthUserUpdateDto;
import uz.enums.HttpStatus;
import uz.exeption.ApiRuntimeException;
import uz.exeption.CustomerSQLException;
import uz.repository.auth.AuthUserRepositoryImpl;
import uz.response.Data;
import uz.response.ResponseEntity;
import uz.security.SecurityHolder;
import uz.services.BaseGenericService;
import uz.services.BaseService;
import uz.services.projectList.ProjectList;

import java.util.Objects;

import static uz.security.SecurityHolder.hasPermission;

/**
 * @author : Oyatjon  -> @data : 00:26
 */

public class AuthUserService extends BaseService<AuthUserRepositoryImpl,
        AuthUserCreateDto,
        AuthUserDto,
        Long> implements BaseGenericService {
    public AuthUserService(AuthUserRepositoryImpl repository) {
        super(repository);
    }

    public ResponseEntity<Data<Boolean>> login(String userName, String password) {
        try {
            SecurityHolder.setSession(repository.login(userName, password));
            return new ResponseEntity<>(new Data<>(true));
        } catch (CustomerSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }


    @Override
    public ResponseEntity<Data<Long>> create(AuthUserCreateDto dto) {
        try {
            hasPermission("CREATE_USER");
            if (Objects.isNull(dto.getOrganizationId()) || !isSuperUser()) {
                dto.setOrganizationId(SecurityHolder.organizationId);
            }
            Long id = repository.create(dto);
            return new ResponseEntity<>(new Data<>(id));
        } catch (Exception e) {
            throw new ApiRuntimeException(e.getMessage(), HttpStatus.UNDEFINED);
        }
    }

    @Override
    public ResponseEntity<AuthUserDto> get(Long id) {
        try {
            hasPermission("CREATE_ORGANIZATION");
            return null;
        } catch (Exception e) {
            return null;
        }
    }


    public ResponseEntity<Data<Long>> updateUser(AuthUserUpdateDto dto) {
        try {
            ///hasPermission("CREATE_USER");
            if (Objects.isNull(dto.getId()) || !isSuperUser()) {
                dto.setId(SecurityHolder.session.getId());
            }
            Long id = repository.updateUser(dto);
            return new ResponseEntity<>(new Data<>(id));
        } catch (Exception e) {
            throw new ApiRuntimeException(e.getMessage(), HttpStatus.UNDEFINED);
        }
    }

    public ResponseEntity<Data<ProjectList>> projectList(Long projectId, Long id) {
        try {
            ProjectList list = repository.prjList(projectId, id);
            return new ResponseEntity<>(new Data<>(list));
        } catch (Exception e) {
            throw new ApiRuntimeException(e.getMessage(), HttpStatus.UNDEFINED);
        }

    }
}

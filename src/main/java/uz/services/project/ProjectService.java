package uz.services.project;

import uz.dtos.project.ProjectCreateDto;
import uz.dtos.project.ProjectDto;
import uz.enums.HttpStatus;
import uz.exeption.ApiRuntimeException;
import uz.repository.project.ProjectRepository;
import uz.response.Data;
import uz.response.ResponseEntity;
import uz.security.SecurityHolder;
import uz.services.BaseGenericService;
import uz.services.BaseService;

import java.util.Objects;

import static uz.security.SecurityHolder.hasPermission;

/**
 * @author : Oyatjon  -> @data : 03:06
 */

public class ProjectService extends BaseService<ProjectRepository,
        ProjectCreateDto, ProjectDto,Long> implements BaseGenericService {
    public ProjectService(ProjectRepository repository) {
        super(repository);
    }

    @Override
    public ResponseEntity<Data<Long>> create(ProjectCreateDto dto) {
        try {
            hasPermission("CREATE_PROJECT");
            if (Objects.isNull(dto.getOrganization_id())) {
                dto.setOrganization_id(SecurityHolder.organizationId);
            }
            Long id = repository.create(dto);
  return new ResponseEntity<>(new Data<>(id));
        }catch (Exception e){
            throw new ApiRuntimeException(e.getMessage(), HttpStatus.UNDEFINED);
        }
    }

    @Override
    public ResponseEntity<ProjectDto> get(Long id) {
        return null;
    }


}

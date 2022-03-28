package uz.services.org;

import uz.dtos.organization.OrgCreateDto;
import uz.dtos.organization.OrgDto;
import uz.dtos.organization.OrgUpdateDto;
import uz.enums.HttpStatus;
import uz.exeption.ApiRuntimeException;
import uz.repository.organization.OrgRepository;
import uz.response.Data;
import uz.response.ResponseEntity;
import uz.services.BaseGenericService;
import uz.services.BaseService;

/**
 * @author : Oyatjon  -> @data : 01:41
 */

public class OrgService extends BaseService<OrgRepository,
        OrgCreateDto, OrgDto, Long> implements BaseGenericService {
    public OrgService(OrgRepository repository) {
        super(repository);
    }

    @Override
    public ResponseEntity<Data<Long>> create(OrgCreateDto dto) {
        try {
            if (isSuperUser()) {
                Long id = repository.create(dto);
                return new ResponseEntity<>(new Data<>(id));
            }
            throw new RuntimeException("NOT_AUTHORIZED");
        } catch (Exception e) {
            throw new ApiRuntimeException(e.getMessage(), HttpStatus.UNDEFINED);
        }
    }

    @Override
    public ResponseEntity<OrgDto> get(Long id) {
        return null;
    }

    public ResponseEntity<Data<Boolean>> updateOrg(OrgUpdateDto dto) {
        try {
            Boolean id = repository.updateOrg(dto);
            return new ResponseEntity<>(new Data<>(id));
        } catch (Exception e) {
            throw new ApiRuntimeException(e.getMessage(), HttpStatus.HTTP_200);
        }
    }

    public ResponseEntity<Data<?>> blockOrg(Integer idd) {
        try {
            repository.blockOrg(idd);
            return new ResponseEntity<>(new Data<>(-1));
        } catch (Exception e) {
            throw new ApiRuntimeException(e.getMessage(), HttpStatus.UNDEFINED);
        }
    }

    public ResponseEntity<Data<?>> unBlockOrg(Integer id) {
        try {
            repository.unBlockOrg(id);
            return new ResponseEntity<>(new Data<>(true));
        }catch (Exception e){
            throw new ApiRuntimeException(e.getMessage(),HttpStatus.UNDEFINED);
        }
    }

    public ResponseEntity<Data<Boolean>> deleteOrg(Integer id) {
        try {
            repository.deleteOrg(id);
            return  new ResponseEntity<>(new Data<>(true));
        }catch (Exception e){
            throw new ApiRuntimeException(e.getMessage(), HttpStatus.UNDEFINED);
        }
    }
}

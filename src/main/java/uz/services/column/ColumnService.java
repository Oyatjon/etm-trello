package uz.services.column;

import uz.dtos.column.ColumnCreateDto;
import uz.dtos.column.ColumnDto;
import uz.enums.HttpStatus;
import uz.exeption.ApiRuntimeException;
import uz.repository.column.ColumnRepository;
import uz.response.Data;
import uz.response.ResponseEntity;
import uz.services.BaseGenericService;
import uz.services.BaseService;

/**
 * @author : Oyatjon  -> @data : 06:01
 */

public class ColumnService extends BaseService<ColumnRepository, ColumnCreateDto, ColumnDto,Long> implements BaseGenericService {
    public ColumnService(ColumnRepository repository) {
        super(repository);
    }

    @Override
    public ResponseEntity<Data<Long>> create(ColumnCreateDto dto) {

        try {
            Long id = repository.create(dto);
        return new ResponseEntity<>(new Data<>(id));
        }catch (Exception e ){
            throw new ApiRuntimeException(e.getMessage() , HttpStatus.UNDEFINED);
        }
    }

    @Override
    public ResponseEntity<ColumnDto> get(Long id) {
        return null;
    }
}

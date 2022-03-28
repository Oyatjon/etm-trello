package uz.services;

import uz.dtos.GenericBaseDto;
import uz.dtos.GenericDto;
import uz.repository.BaseRepository;
import uz.response.Data;
import uz.response.ResponseEntity;

import java.io.Serializable;

import static uz.security.SecurityHolder.session;

/**
 * @author : Oyatjon  -> @data : 01:38
 */

/**
 * @param <R> Repository
 */

public abstract class BaseService<R extends BaseRepository,
        CR extends GenericBaseDto,
        D extends GenericDto,
        K extends Serializable> {
    protected R repository;

    protected BaseService() {
    }


    public BaseService(R repository) {
        this.repository = repository;
    }

    public abstract ResponseEntity<Data<Long>> create(CR dto);

    public abstract ResponseEntity<D> get(K id);


    public boolean isSuperUser() {
        return session.isIsSuperUser();
    }
    public  boolean isAdmin(){return  session.getRoles().stream().anyMatch(role ->role.getCode().equals("ADMIN"));}

}

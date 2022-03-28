package uz.ui;

import uz.response.Data;
import uz.response.ResponseEntity;
import uz.services.BaseGenericService;

/**
 * @author : Oyatjon  -> @data : 23:08
 */

public class BaseUI <S extends BaseGenericService>{

     protected  final  S service;
     public  BaseUI(S service ){this.service = service;}

    protected  void  showResponse(ResponseEntity<Data<Boolean>> response)
    {

    }

}

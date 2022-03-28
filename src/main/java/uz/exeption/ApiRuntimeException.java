package uz.exeption;

import lombok.Getter;
import uz.enums.HttpStatus;

/**
 * @author : Oyatjon  -> @data : 23:18
 */
@Getter
public class ApiRuntimeException extends RuntimeException{
 private Integer status;

 public  ApiRuntimeException(String message, HttpStatus status){
     super(message);
     this.status = status.getCode();
 }
}

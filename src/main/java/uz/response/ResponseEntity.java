package uz.response;

/**
 * @author : Oyatjon  -> @data : 01:28
 */

import lombok.Getter;
import lombok.Setter;
import uz.enums.HttpStatus;

/**
 *
 * @param <D> response body type
 */
@Getter
@Setter
public class ResponseEntity<D> {
 private  D body;
 private Integer status;

 public ResponseEntity(D body){this(body, HttpStatus.HTTP_200);}

    public ResponseEntity(D body, HttpStatus status){
     this.body = body;
     this.status = status.getCode();
    }

}

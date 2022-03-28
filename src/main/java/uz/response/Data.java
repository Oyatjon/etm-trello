package uz.response;

import lombok.Getter;

/**
 * @author : Oyatjon  -> @data : 01:28
 */


/**
 *
 * @param <B> body
 */
@Getter
public class Data<B> {
    private  B data;
    private  Long total;
    public Data(B data){this(data,0L);}

    public Data(B data,Long total){
        this.data = data;
        this.total = total;
    }
}

package uz.property;

import javax.imageio.IIOException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



/**
 * @author : Oyatjon  -> @data : 00:00
 */

public abstract class BaseProperty {
    protected Properties properties = new Properties();

    protected  BaseProperty(String path){load(path);}

    private  void  load(String path ){
        try {
            FileReader fileReader = new FileReader(path);
            properties.load(fileReader);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
public String get(String key) {return  properties.getProperty(key);}
}

package uz.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author : Oyatjon  -> @data : 23:56
 */

public class BaseUtils {
    public static final Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
}

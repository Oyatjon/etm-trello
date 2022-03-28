package uz.services.projectList;

import com.google.gson.annotations.SerializedName;
import lombok.ToString;

public class LabelsItem{

    @SerializedName("color")
    private String color;

    @SerializedName("id")
    private int id;

    @SerializedName("text")
    private Object text;

    public String getColor(){
        return color;
    }

    public int getId(){
        return id;
    }

    public Object getText(){
        return text;
    }

    @Override
    public String toString() {
        return "LabelsItem{" +
                "color='" + color + '\'' +
                ", id=" + id +
                ", text=" + text +
                '}';
    }
}
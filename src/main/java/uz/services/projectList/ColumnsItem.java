package uz.services.projectList;

import com.google.gson.annotations.SerializedName;
import lombok.ToString;

import java.util.List;

public class ColumnsItem{

    @SerializedName("emoji")
    private Object emoji;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    @SerializedName("tasks")
    private List<TasksItem> tasks;

    public Object getEmoji(){
        return emoji;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public List<TasksItem> getTasks(){
        return tasks;
    }

    @Override
    public String toString() {
        return "ColumnsItem{" +
                "emoji=" + emoji + "\n"+
                ", name='" + name + '\'' +
                ", id=" + id +
                ", tasks=" + tasks +"\n"+
                '}';
    }
}
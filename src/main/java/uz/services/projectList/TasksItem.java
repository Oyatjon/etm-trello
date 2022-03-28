package uz.services.projectList;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.ToString;


public class TasksItem{

    @SerializedName("comments")
    private List<CommentsItem> comments;

    @SerializedName("level")
    private String level;

    @SerializedName("members")
    private List<MembersItem> members;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("id")
    private int id;

    @SerializedName("deadline")
    private String deadline;

    @SerializedName("priority")
    private String priority;

    public List<CommentsItem> getComments(){
        return comments;
    }

    public String getLevel(){
        return level;
    }

    public List<MembersItem> getMembers(){
        return members;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getId(){
        return id;
    }

    public String getDeadline(){
        return deadline;
    }

    public String getPriority(){
        return priority;
    }

    @Override
    public String toString() {
        return "TasksItem{" +
                "comments=" + comments +
                ", level='" + level + '\'' +"\n"+
                ", members=" + members + "\n"+
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", deadline='" + deadline + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
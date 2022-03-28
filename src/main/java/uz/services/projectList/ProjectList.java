package uz.services.projectList;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.ToString;


public class ProjectList{

    @SerializedName("organizationId")
    private int organizationId;

    @SerializedName("code")
    private String code;

    @SerializedName("tz")
    private String tz;

    @SerializedName("columns")
    private List<ColumnsItem> columns;

    @SerializedName("background")
    private String background;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("projectMembers")
    private List<ProjectMembersItem> projectMembers;

    @SerializedName("id")
    private int id;

    @SerializedName("labels")
    private List<LabelsItem> labels;

    public int getOrganizationId(){
        return organizationId;
    }

    public String getCode(){
        return code;
    }

    public String getTz(){
        return tz;
    }

    public List<ColumnsItem> getColumns(){
        return columns;
    }

    public String getBackground(){
        return background;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public List<ProjectMembersItem> getProjectMembers(){
        return projectMembers;
    }

    public int getId(){
        return id;
    }

    public List<LabelsItem> getLabels(){
        return labels;
    }

    @Override
    public String toString() {
        return "ProjectList{" +
                "organizationId=" + organizationId +
                ", tz='" +  tz + '\'' +"\n"+
                ", columns=" + columns + "\n" +
                ", background='" + background + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +"\n"+
                ", projectMembers=" + projectMembers +"\n"+
                ", labels=" + labels +"\n" +
                '}';
    }
}
package uz.services.projectList;

import com.google.gson.annotations.SerializedName;

public class CommentsItem{

    @SerializedName("is_deleted")
    private boolean isDeleted;

    @SerializedName("updated_at")
    private Object updatedAt;

    @SerializedName("updated_by")
    private Object updatedBy;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("task_id")
    private int taskId;

    @SerializedName("id")
    private int id;

    @SerializedName("type")
    private int type;

    @SerializedName("message")
    private String message;

    @SerializedName("created_by")
    private int createdBy;

    public boolean isIsDeleted(){
        return isDeleted;
    }

    public Object getUpdatedAt(){
        return updatedAt;
    }

    public Object getUpdatedBy(){
        return updatedBy;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public int getTaskId(){
        return taskId;
    }

    public int getId(){
        return id;
    }

    public int getType(){
        return type;
    }

    public String getMessage(){
        return message;
    }

    public int getCreatedBy(){
        return createdBy;
    }

    @Override
    public String toString() {
        return "CommentsItem{" +
                "isDeleted=" + isDeleted +
                ", updatedAt=" + updatedAt +
                ", updatedBy=" + updatedBy +
                ", createdAt='" + createdAt + '\'' +
                ", taskId=" + taskId +
                ", id=" + id +
                ", type=" + type +
                ", message='" + message + '\'' +
                ", createdBy=" + createdBy +
                '}';
    }
}
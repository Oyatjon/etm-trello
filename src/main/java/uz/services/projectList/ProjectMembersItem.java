package uz.services.projectList;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.ToString;


public class ProjectMembersItem{

    @SerializedName("is_lead")
    private boolean isLead;

    @SerializedName("userinfo")
    private List<UserinfoItem> userinfo;

    @SerializedName("memberid")
    private int memberid;

    public boolean isIsLead(){
        return isLead;
    }

    public List<UserinfoItem> getUserinfo(){
        return userinfo;
    }

    public int getMemberid(){
        return memberid;
    }

    @Override
    public String toString() {
        return "ProjectMembersItem{" +
                "isLead=" + isLead + "\n"+
                ", userinfo=" + userinfo +"\n"+
                ", memberid=" + memberid +
                '}';
    }
}
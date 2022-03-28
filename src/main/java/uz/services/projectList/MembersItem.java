package uz.services.projectList;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MembersItem{

    @SerializedName("userinfo")
    private List<UserinfoItem> userinfo;

    @SerializedName("memberid")
    private int memberid;

    public List<UserinfoItem> getUserinfo(){
        return userinfo;
    }

    public int getMemberid(){
        return memberid;
    }

    @Override
    public String toString() {
        return "MembersItem{" +
                "userinfo=" + userinfo + "\n"+
                ", memberid=" + memberid +
                '}';
    }
}
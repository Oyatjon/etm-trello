package uz.services.projectList;

import com.google.gson.annotations.SerializedName;

public class UserinfoItem{

    @SerializedName("firstname")
    private String firstname;

    @SerializedName("code")
    private String code;

    @SerializedName("phone")
    private String phone;

    @SerializedName("language")
    private String language;

    @SerializedName("id")
    private int id;

    @SerializedName("email")
    private String email;

    @SerializedName("lastname")
    private String lastname;

    @SerializedName("username")
    private String username;

    public String getFirstname(){
        return firstname;
    }

    public String getCode(){
        return code;
    }

    public String getPhone(){
        return phone;
    }

    public String getLanguage(){
        return language;
    }

    public int getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public String getLastname(){
        return lastname;
    }

    public String getUsername(){
        return username;
    }

    @Override
    public String toString() {
        return "UserinfoItem{" +
                "firstname='" + firstname + '\'' +
                ", code='" + code + '\'' +
                ", phone='" + phone + '\'' +
                ", language='" + language + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
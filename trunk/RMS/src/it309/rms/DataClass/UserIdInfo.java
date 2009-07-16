package it309.rms.dataclass;

import java.io.Serializable;

public class UserIdInfo implements Cloneable, Serializable{

    private String name;

    private String id;

    private String password;

    public UserIdInfo() {
    }

    

    public UserIdInfo(String id, String password) {
        this.id = id;
        this.password = password;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
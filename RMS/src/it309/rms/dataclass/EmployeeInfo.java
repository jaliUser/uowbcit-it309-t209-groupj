package it309.rms.dataclass;

import java.io.Serializable;

public class EmployeeInfo extends UserIdInfo implements Cloneable, Serializable{
  /* {src_lang=Java}*/

    private String adress;

    private String title;

    private String phone;

    private String email;



    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
package com.example.mousun.jupigoproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mousun on 10/26/17.
 */


/*
 *  This class stores the information of each submitted user
 */
public class UserObject {

    int user_code;
    String user_name;
    String uesr_color;

    public UserObject(int user_code, String user_name, String uesr_color) {
        this.user_code = user_code;
        this.user_name = user_name;
        this.uesr_color = uesr_color;
    }

    public int getUser_code() {
        return user_code;
    }

    public void setUser_code(int user_code) {
        this.user_code = user_code;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUesr_color() {
        return uesr_color;
    }

    public void setUesr_color(String uesr_color) {
        this.uesr_color = uesr_color;
    }
}

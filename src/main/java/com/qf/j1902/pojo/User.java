package com.qf.j1902.pojo;

import lombok.Data;

/**
 * Created by 苏沐挽余寄笙歌 on 2019/5/27.
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String Email;
    private String idnumber;
    private String yhname;

    public User() {
    }

    public User(String username, String password, String email, String idnumber) {
        this.username = username;
        this.password = password;
        Email = email;
        this.idnumber = idnumber;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password, String email, String idnumber, String yhname) {
        this.id = id;
        this.username = username;
        this.password = password;
        Email = email;
        this.idnumber = idnumber;
        this.yhname = yhname;
    }

    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User u = (User) obj;
            return this.username.equals(u.username)
                    && this.password.equals(password);
        }
        return super.equals(obj);
    }

    }

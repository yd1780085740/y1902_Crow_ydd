package com.qf.j1902.pojo;

import lombok.Data;

/**
 * Created by 苏沐挽余寄笙歌 on 2019/5/30.
 */
@Data
public class UserInfo {
    private String classify;
    private String uname;
    private String idcard;
    private String phonenumb;
    private String photo;
    private String Email;
    private int id;

    public UserInfo() {
    }

    public UserInfo(String classify, String uname, String idcard, String phonenumb, String photo, String email) {
        this.classify = classify;
        this.uname = uname;
        this.idcard = idcard;
        this.phonenumb = phonenumb;
        this.photo = photo;
        this.Email = email;
    }
}

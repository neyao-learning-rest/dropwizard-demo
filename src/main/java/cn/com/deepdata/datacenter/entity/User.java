package cn.com.deepdata.datacenter.entity;

/**
 * A simple bean
 * Created by neyao@github.com on 2016/4/2.
 */
public class User {

    private int id;

    private String userName;

    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

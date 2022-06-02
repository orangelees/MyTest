package com.lqs.model;

/**
 * @author lqs
 * @date 2022/3/8 19:29
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private String phone;

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int id, String username, String password) {

        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public User(String username, String password) {

        this.username = username;
        this.password = password;
    }
    public User(int id, String username, String password, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }
    public User(String username, String password, String name, String phone) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }
    public User(String phone) {
        super();
        this.phone = phone;
    }

}

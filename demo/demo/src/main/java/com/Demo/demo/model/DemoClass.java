package com.Demo.demo.model;

public class DemoClass {
    private String userId;
    private String userName;

    public DemoClass(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public DemoClass() {
    }

    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {

        this.userId = userId;
    }

    public String getUsername() {

        return userName;
    }

    public void setUsername(String userName) {

        this.userName = userName;
    }
}

package com.torchacademy.maintenancemanagement.sqlite.model;

/**
 * Created by zeinab.serhan on 6/21/2016.
 */
public class User {
    private static User instance = null;
    String name;
    int userId;
    protected User() {
    }
    public static User getUser() {
        if(instance == null) {
            instance = new User();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

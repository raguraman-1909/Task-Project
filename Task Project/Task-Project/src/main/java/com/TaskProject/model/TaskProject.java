package com.TaskProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "user_details")
public class TaskProject {
    @Id
    private String userId;
    private String userName;
    private String userPassword;
    private String description;
    private String dueDate;
    private String status;

    public TaskProject() {
    }

    public TaskProject(String userId, String userName, String userPassword, String description, String dueDate, String status) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

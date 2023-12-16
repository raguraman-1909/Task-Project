package com.TaskProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name= "user_details") //for table in db
public class TaskProject {
    @Id
    private String userId;
    private String userName;
    private String userPassword;
    private String description;
    private LocalDate dueDate;
    private String status;

    public TaskProject() {
    }

    public TaskProject(String userId, String userName, String userPassword, String description, LocalDate dueDate, String status) {
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
  /*If you want to change the date format
   public void setDueDate(String dueDate) {
        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        // Parse the input string to a LocalDate
        this.dueDate = LocalDate.parse(dueDate, formatter);*/
}

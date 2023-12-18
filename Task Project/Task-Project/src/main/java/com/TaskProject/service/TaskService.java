package com.TaskProject.service;

import com.TaskProject.model.Task;
import com.TaskProject.model.User;

import java.util.List;

//Service interface for managing tasks in the system
public interface TaskService {

    //Creates a new task.
    void createTask(Task task);

    // Updates an existing task.
    void updateTask(Long id, Task task);

    void deleteTask(Long id);    //Deletes a task by its ID.

    List<Task> findAll();    //Retrieves a list of all tasks in the system.

    List<Task> findByOwnerOrderByDateDesc(User user);    //Retrieves tasks owned by a user, ordered by date in descending order.

    void setTaskCompleted(Long id);    //Marks a task as completed.

    void setTaskNotCompleted(Long id);    //Marks a task as not completed.
    
    List<Task> findFreeTasks();    //Retrieves a list of tasks not assigned to any user.

    Task getTaskById(Long taskId);    //Retrieves a task by its ID

    void assignTaskToUser(Task task, User user);    //Assigns a task to a user.

    void unassignTask(Task task);    //Unassigns a task to a user.
}

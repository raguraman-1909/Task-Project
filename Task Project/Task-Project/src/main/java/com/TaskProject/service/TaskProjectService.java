package com.TaskProject.service;

import com.TaskProject.model.TaskProject;

import java.util.List;

public interface TaskProjectService {
    public String createTaskProject(TaskProject taskProject);
    public String updateTaskProject(TaskProject taskProject);
    public String deleteTaskProject(String userId);
    public TaskProject getTaskProject(String userId);
    public List<TaskProject> getAllTaskProject();
}

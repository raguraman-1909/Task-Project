package com.TaskProject.Task.Project.service;

import com.TaskProject.Task.Project.model.TaskProject;

import java.util.List;

public interface TaskProjectService {
    public String createTaskProject(TaskProject taskProject);
    public String updateTaskProject(TaskProject taskProject);
    public String deleteTaskProject(String userId);
    public TaskProject getTaskProject(String userId);
    public List<TaskProject> getAllTaskProject();
}

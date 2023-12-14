package com.TaskProject.Task.Project.service;

import com.TaskProject.Task.Project.model.TaskProject;
import com.TaskProject.Task.Project.repository.TaskProjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskProjectServiceImpl implements TaskProjectService{

    TaskProjectRepo taskProjectRepo;
    public TaskProjectServiceImpl(TaskProjectRepo taskProjectRepo) {
        this.taskProjectRepo = taskProjectRepo;
    }


    @Override
    public String createTaskProject(TaskProject taskProject) {
        taskProjectRepo.save(taskProject);  //passing the entity(taskproject) with this the data via repository layer will be saved inside the database
        return "Successfully Created";
    }

    @Override
    public String updateTaskProject(TaskProject taskProject) {
        taskProjectRepo.save(taskProject);
        return "Successfully Updated";
    }

    @Override
    public TaskProject getTaskProject(String userId) {
        return  taskProjectRepo.findById(userId).get(); //find by id and using get method to get the value
    }

    @Override
    public List<TaskProject> getAllTaskProject() {
        return taskProjectRepo.findAll();   // getting all the data by using findall method
    }

    @Override
    public String deleteTaskProject(String userId) {
        taskProjectRepo.deleteById(userId);
        return "Successfully Deleted";
    }
}

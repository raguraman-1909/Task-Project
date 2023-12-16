package com.TaskProject.service;

import com.TaskProject.exception.TaskManagerNotFoundException;
import com.TaskProject.model.TaskProject;
import com.TaskProject.repository.TaskProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskProjectServiceImpl implements TaskProjectService {

    TaskProjectRepo taskProjectRepo;
    @Autowired
    public TaskProjectServiceImpl(TaskProjectRepo taskProjectRepo) {
        this.taskProjectRepo = taskProjectRepo;
    }


    @Override
    public String createTaskProject(TaskProject taskProject) {
        taskProjectRepo.save(taskProject);  //passing the entity(TaskProject) with this the data via repository layer will be saved inside the database
        return "Successfully Created";
    }

    @Override
    public String updateTaskProject(TaskProject taskProject) {
        taskProjectRepo.save(taskProject);  // for update if you want to change the dueDate or status etc...
        return "Successfully Updated";
    }

    @Override
    public TaskProject getTaskProject(String userId) {
        if(taskProjectRepo.findById(userId).isEmpty())
            throw new TaskManagerNotFoundException("Requested Task does not exist");
        return  taskProjectRepo.findById(userId).get(); //find by id and using get method to get the value
    }

    @Override
    public List<TaskProject> getAllTaskProject() {
        return taskProjectRepo.findAll();   // getting all the data by using findAll method
    }

    @Override
    public String deleteTaskProject(String userId) {
        taskProjectRepo.deleteById(userId); //Delete the user by using userId
    return "Sucessfully Deleted";
    }
}

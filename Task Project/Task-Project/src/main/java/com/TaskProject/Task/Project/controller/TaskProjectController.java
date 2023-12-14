package com.TaskProject.Task.Project.controller;

import com.TaskProject.Task.Project.model.TaskProject;
import com.TaskProject.Task.Project.service.TaskProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskproject")
public class TaskProjectController {

    TaskProjectService taskProjectService;   // instance of service layer because contol layer is communicating with the service layer
    public TaskProjectController(TaskProjectService taskProjectService) {
        this.taskProjectService = taskProjectService;
    }

    //read one user from DB
    @GetMapping("{userId}")
    public TaskProject getTaskProjectDetails(@PathVariable("userId") String userId) //whatever userid is coming (pathvariable)here it will be used in string and finally extracted
    {
        return   taskProjectService.getTaskProject(userId); //to get the user details by using userid
    }

    //read all user from DB
    @GetMapping("/taskproject")
    public List<TaskProject> getAllTaskProjectDetails() //whatever userid is coming (pathvariable)here it will be used in string and finally extracted
    {
        return   taskProjectService.getAllTaskProject(); //to get all the user details by using list
    }

    @PostMapping
    public String createTaskProjectDetails(@RequestBody TaskProject taskProject){
        taskProjectService.createTaskProject(taskProject);  //with this service layer call repo layer and create value in the database
        return "Task Manager Created Successfully";
    }

    @PutMapping
    public String updateTaskProjectDetails(@RequestBody TaskProject taskProject){
        taskProjectService.updateTaskProject(taskProject);  //updating the value with request body(taskProject)
        return "Task Manager updated Successfully";
    }

    @DeleteMapping("{userId}")
    public String deleteTaskProjectDetails(@PathVariable("userId") String userId)
    {
       taskProjectService.deleteTaskProject(userId);  //deleting the user by using the userid
        return "Task Manager deleted Successfully";
    }
}

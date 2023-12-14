package com.TaskProject.Task.Project.repository;

import com.TaskProject.Task.Project.model.TaskProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskProjectRepo extends JpaRepository <TaskProject, String> {

}

package com.TaskProject.repository;


import com.TaskProject.model.TaskProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskProjectRepo extends JpaRepository <TaskProject, String> {

}

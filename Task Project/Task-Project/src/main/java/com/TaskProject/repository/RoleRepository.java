package com.TaskProject.repository;

import com.TaskProject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {    Repository interface for managing roles in the system.
    //Jpa repsitory provides a set of generic CRUD (Create, Read, Update, Delete) operations for working with entities.
    Role findByRole(String user);
}


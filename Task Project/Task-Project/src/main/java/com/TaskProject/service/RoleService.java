package com.TaskProject.service;

import com.TaskProject.model.Role;

import java.util.List;

//Service interface for managing roles in the system.
public interface RoleService {
    //to create a role
    Role createRole(Role role);

    // to list all the role
    List<Role> findAll();
}

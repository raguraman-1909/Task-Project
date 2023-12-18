package com.TaskProject.service;

import com.TaskProject.model.Role;

import java.util.List;


public interface RoleService {
    Role createRole(Role role);

    List<Role> findAll();
}
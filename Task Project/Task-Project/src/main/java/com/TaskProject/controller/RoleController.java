package com.TaskProject.controller;

import com.TaskProject.model.Role;
import com.TaskProject.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @PostMapping
    public ResponseEntity<String> createRole(@RequestBody Role role) {

        roleService.createRole(role);
        return ResponseEntity.ok("Role Created Successfully");
    }



}

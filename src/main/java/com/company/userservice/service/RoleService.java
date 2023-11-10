package com.company.userservice.service;

import com.company.userservice.model.entity.Role;
import com.company.userservice.model.enums.Roles;

import java.util.List;


public interface RoleService {
    Role findByRoleName(Roles eRole);

    List<Role> getAllRoles();
}
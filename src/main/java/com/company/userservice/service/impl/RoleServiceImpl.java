package com.company.userservice.service.impl;

import com.company.userservice.model.entity.Role;
import com.company.userservice.model.enums.Roles;
import com.company.userservice.repository.RoleRepository;
import com.company.userservice.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role findByRoleName(Roles eRole) {
        return roleRepository.findByRoleName(eRole);
    }

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }
}
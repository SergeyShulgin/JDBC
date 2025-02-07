package com.andreyb34rus.JM_Task_3_1_3.service;

import com.andreyb34rus.JM_Task_3_1_3.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleByName(String name);
}

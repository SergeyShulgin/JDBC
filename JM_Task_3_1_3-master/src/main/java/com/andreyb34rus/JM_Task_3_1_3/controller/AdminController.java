package com.andreyb34rus.JM_Task_3_1_3.controller;

import com.andreyb34rus.JM_Task_3_1_3.model.User;
import com.andreyb34rus.JM_Task_3_1_3.service.RoleService;
import com.andreyb34rus.JM_Task_3_1_3.service.UserService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "")
    public String getAdminPage(Model model, Principal principal) {
        if (principal != null) {
            var user = userService.findByUsername(principal.getName());
            if (user != null) {
                model.addAttribute("user", user);
            }
        }
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("emptyUser", new User());
        return "/admin";
    }

    @PostMapping("/addUser")
    public String createUser(@ModelAttribute("emptyUser") User user,
                             @RequestParam(value = "checkedRoles") String[] selectResult) {
        for (String s : selectResult) {
            var role = roleService.getRoleByName("ROLE_" + s);
            if (role != null) {
                user.addRole(role);
            }
        }
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @PostMapping("/updateUser/{id}")
    public String updateUser(@ModelAttribute("emptyUser") User user, @PathVariable("id") Long id,
                             @RequestParam(value = "userRolesSelector") String[] selectResult) {
        for (String s : selectResult) {
            var role = roleService.getRoleByName("ROLE_" + s);
            if (role != null) {
                user.addRole(role);
            }
        }
        userService.updateUser(user);
        return "redirect:/admin";
    }
}

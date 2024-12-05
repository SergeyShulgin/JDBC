package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    UserController userController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", UserService.getAllUsers());
        return "users";
    }

    @GetMapping("/users")
    public String getUserById(@RequestParam("id") long id) {
        UserService.getUserById(id);
        return "redirect:/users";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute("user") User user) {
        UserService.addUser(user);
        return "redirect:/users";
    }

    @PostMapping("/users/delete")
    public String removeUser(@RequestParam("id") long id) {
        UserService.removeUser(id);
        return "redirect:/users";
    }

    @PostMapping("/users/update")
    public String updateUser(@ModelAttribute("user") User user) {
        UserService.updateUser(user);
        return "redirect:/users";
    }

}

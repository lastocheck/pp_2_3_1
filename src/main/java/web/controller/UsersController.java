package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsersPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("newUser", new User());
        return "users/users";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getUsername() != null && !user.getUsername().isBlank()) {
            userService.save(user);
        }
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        if (id > 0) {
            userService.delete(id);
        }
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String getUpdatePage(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "users/update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }
}

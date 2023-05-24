package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserService;
import ru.kata.spring.boot_security.demo.utils.UsersCreationDto;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showIndexPage(Model model) {
        UsersCreationDto usersForm = new UsersCreationDto(userService.getListUsers());

        model.addAttribute("form", usersForm);
        return "users/admin";
    }

    @GetMapping("new")
    public String showUserCreationPage(Model model) {
        model.addAttribute("user", new User());

        return "users/new";
    }

    @PostMapping
    public String createNewUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/admin";
    }

    @PatchMapping
    public String updateUser(@ModelAttribute UsersCreationDto form) {
        userService.update(form.getUsers());
        return "redirect:/admin";
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.removeById(id);
        return "redirect:/admin";
    }

}

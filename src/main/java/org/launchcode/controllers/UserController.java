package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping("/add")
    public String processAddUserForm(@ModelAttribute @Valid User user, String verify, Model model, Errors errors) {
        if(errors.hasErrors()){
            model.addAttribute("error", "there are errors");
            System.out.println("Error if statement was hit");
            return "user/add";
        }

        model.addAttribute("user", user);
        model.addAttribute("verify", verify);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        if (user.getPassword().equals(verify)) {
            return "user/index";
        }
        else {
            return "user/add";
        }
    }
}
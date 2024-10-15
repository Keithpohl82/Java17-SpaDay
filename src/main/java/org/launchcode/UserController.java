package org.launchcode;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/index")
    public String displayAddUserForm() {
        return "user/index";
    }

    @GetMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
            model.addAttribute("userName", user.getUserName());
            return "user/index";

//        else {
//            String errorMessage = "Passwords did not match";
//            model.addAttribute("error", errorMessage);
//            model.addAttribute("userName", user.getUserName());
//            model.addAttribute("email", user.getEmail());
//
//            return "/user/add";
        //}

    }

}

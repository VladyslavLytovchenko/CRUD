package nure.lytovchenko.Controllers;

import nure.lytovchenko.Models.Role;
import nure.lytovchenko.Models.User;
import nure.lytovchenko.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/reg")
    public String signUp(Model model) {
        model.addAttribute("user", new User());
        return "reg";
    }

    @PostMapping("/reg")
    public String saveUser(@ModelAttribute User user) {
        userService.save(user);
        return "login";
    }

    @PostMapping(value = "/editUser/{name}")
    public String addItem(@PathVariable String name, @ModelAttribute("user") User user) {
        System.out.println(user.getUsername());
        //userService.delete(user.getUsername());
        userService.save(user);
        return "redirect:/items";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        System.out.println("/users");
        model.addAttribute("roles", new Role[]{new Role("ROLE_ADMIN"),new Role("ROLE_USER")});
        model.addAttribute("users", userService.listUsers());
        model.addAttribute("user",new User());
        return "users";
    }

}

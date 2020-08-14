package nure.lytovchenko.Controllers;

import nure.lytovchenko.DAO.RoleDAO;
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

    @Autowired
    RoleDAO roleDAO;

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

    @PostMapping("/editUser/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteItem(@PathVariable int id, @ModelAttribute("user") User user) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("roles", roleDAO.listRoles());
        model.addAttribute("users", userService.listUsers());
        model.addAttribute("user",new User());
        return "users";
    }

}

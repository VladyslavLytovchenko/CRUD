package nure.lytovchenko.Controllers;

import nure.lytovchenko.DAO.UserDAO;
import nure.lytovchenko.Models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserDAO userDAO;

    @GetMapping("/login")
    public String Login()
    {
        System.out.println("111111");
        for (Role role: userDAO.getUserByUsername("jackman").getRoles())
            System.out.println(role.getRole());
        return "login";
    }

}

package nure.lytovchenko.Services;

import nure.lytovchenko.DAO.RoleDAO;
import nure.lytovchenko.DAO.UserDAO;
import nure.lytovchenko.Models.Role;
import nure.lytovchenko.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.logging.Logger;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getRole(15));
        user.setRoles(roles);
        userDAO.save(user);
    }

    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    public void update(User user) {
        Set<Role> roles = new HashSet<>();
        for(Role r : user.getRoles()){
            roles.add(roleDAO.getRole(Integer.parseInt(r.getRole())));
        }
        for(Role r : user.getRoles()){
            System.out.println("asd" + r.getRole() + "  " + r.getId() );
        }
        user.setRoles(roles);
        userDAO.update(user);
    }


}

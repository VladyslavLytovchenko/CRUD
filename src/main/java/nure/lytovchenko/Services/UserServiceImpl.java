package nure.lytovchenko.Services;

import nure.lytovchenko.DAO.RoleDAO;
import nure.lytovchenko.DAO.UserDAO;
import nure.lytovchenko.Models.Role;
import nure.lytovchenko.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

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
        roles.add(roleDAO.getRole(1));
        user.setRoles(roles);
        //if(userDAO.getUserByUsername(user.getUsername())!=null){
         //   set = user.getRoles();
         //   for(Role role : set){
         //       role.setUser(user);
         //   }
         //   user = userDAO.getUserByUsername(user.getUsername());
       // }
        //System.out.println("+++");
        //set = user.getRoles().stream().peek(x -> System.out.println(x.getRole())).peek(x -> x.setUser(user)).collect(Collectors.toSet());
        //user.setRoles(Collections.singleton(new Role(user, "ROLE_USER")));

        userDAO.save(user);
    }

    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    //@Override
   // public void delete(String username) {
    //    userDAO.delete(username);
    //}



}

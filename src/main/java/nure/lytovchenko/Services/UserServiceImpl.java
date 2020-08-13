package nure.lytovchenko.Services;

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

@Service("userDetailsService")
@Transactional
@Order(1)
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional()
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = userDAO.getUserByUsername(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
        return buildUserForAuthentication(user, authorities);

    }

    public void saveOrUpdateUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> set = Collections.singleton(new Role(user,"ROLE_USER"));
        //if(userDAO.getUserByUsername(user.getUsername())!=null){
         //   set = user.getRoles();
         //   for(Role role : set){
         //       role.setUser(user);
         //   }
         //   user = userDAO.getUserByUsername(user.getUsername());
       // }

        user.setRoles(set);
        //System.out.println("+++");
        //set = user.getRoles().stream().peek(x -> System.out.println(x.getRole())).peek(x -> x.setUser(user)).collect(Collectors.toSet());
        //user.setRoles(Collections.singleton(new Role(user, "ROLE_USER")));

        userDAO.saveOrUpdateUser(user);
    }

    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Override
    public void delete(String username) {
        userDAO.delete(username);
    }

    private org.springframework.security.core.userdetails.User buildUserForAuthentication(nure.lytovchenko.Models.User user,
                                                                                          List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> setAuths = new HashSet<>();
        for (Role userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        List<GrantedAuthority> result = new ArrayList<>(setAuths);
        return result;
    }


}

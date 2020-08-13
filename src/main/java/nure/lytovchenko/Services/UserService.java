package nure.lytovchenko.Services;

import nure.lytovchenko.Models.User;

import java.util.List;

public interface UserService {
   void save(User user);


   //void delete(String username);

   User findByUsername(String username);

   List<User> listUsers();
}

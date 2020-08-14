package nure.lytovchenko.Services;

import nure.lytovchenko.Models.User;

import java.util.List;

public interface UserService {
   void save(User user);

   void delete(int id);

   void update(User user);

   User findByUsername(String username);

   List<User> listUsers();
}

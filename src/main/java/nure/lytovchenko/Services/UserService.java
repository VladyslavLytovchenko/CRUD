package nure.lytovchenko.Services;

import nure.lytovchenko.Models.User;

import java.util.List;

public interface UserService {
   void saveOrUpdateUser(User user);

   void delete(String username);

   List<User> listUsers();
}

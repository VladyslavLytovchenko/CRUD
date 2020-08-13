package nure.lytovchenko.DAO;

import nure.lytovchenko.Models.User;

import java.util.List;

public interface UserDAO {
    User getUserByUsername(String username);

    void saveOrUpdateUser(User user);

    void delete(String username);

    List<User> listUsers();
}

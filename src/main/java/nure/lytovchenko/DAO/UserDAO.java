package nure.lytovchenko.DAO;

import nure.lytovchenko.Models.User;

public interface UserDAO {
    User getUserByUsername(String username);

    void saveUser(User user);
}

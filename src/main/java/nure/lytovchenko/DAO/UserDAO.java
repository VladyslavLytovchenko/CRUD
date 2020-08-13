package nure.lytovchenko.DAO;

import nure.lytovchenko.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDAO {
    User findByUsername(String username);

    void save(User user);

    List<User> listUsers();
}

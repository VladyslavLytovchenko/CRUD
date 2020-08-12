package nure.lytovchenko.Services;

import nure.lytovchenko.Models.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    User getUserByUsername(String username);
}

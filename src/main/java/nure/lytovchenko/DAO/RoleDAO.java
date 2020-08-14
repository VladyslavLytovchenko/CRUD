package nure.lytovchenko.DAO;

import nure.lytovchenko.Models.Role;

import java.util.List;

public interface RoleDAO {
    Role getRole(int id);

    Role getRole(String role);

    List<Role> listRoles();

}

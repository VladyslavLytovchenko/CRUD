package nure.lytovchenko.Models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;

    @Column
    private String role;

   @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(){}

    public Role(String role){
        this.role = role;
    }

    public Role(Set<User> users,String  role){
        this.users = users;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return Objects.equals(role, role1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }

    @Override
    public String toString() {
        return role;
    }
}

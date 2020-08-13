package nure.lytovchenko.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String role;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="username")
    private User user;

    public Role(){}

    public Role(String role){
        this.role = role;
    }

    public Role(User user,String role){
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return role.equals(role1.role) &&
                user.equals(role1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, user);
    }
}

package nure.lytovchenko.Models;

import javax.persistence.*;

@Entity
@Table
public class Role {

    @Id
    @Column
    private int id;

    @Column
    private String role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="username")
    private User user;

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
}

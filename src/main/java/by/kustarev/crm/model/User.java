package by.kustarev.crm.model;

import java.sql.Date;
import java.util.Objects;

public class User {
    private final Long id;
    private final String login;
    private final String password;
    private final Date dateCreated;
    private final Roles role;

    public User(Long id, String login, String password, Date dateCreated, Roles role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.dateCreated = dateCreated;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Roles getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(dateCreated, user.dateCreated) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, dateCreated, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", dateCreated=" + dateCreated + '\'' +
                ", role=" + role +
                '}';
    }
}

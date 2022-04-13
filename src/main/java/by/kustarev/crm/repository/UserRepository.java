package by.kustarev.crm.repository;

import by.kustarev.crm.model.Roles;
import by.kustarev.crm.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    private static final String URL = "jdbc:mysql://localhost:3306/crm";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static final String CHECK_USER =
            "select * from users where login = ? and password = ?";

    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static User getUserByLoginAndPassword(String login, String password) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(CHECK_USER);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();

            if (rs.next())
                user = new User(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        Roles.valueOf(rs.getString(5)));

            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}

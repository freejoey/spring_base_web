package mx.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapper implements org.springframework.jdbc.core.RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.id = resultSet.getLong("id");
        user.phoneNum = resultSet.getLong("phone_num");
        user.name = resultSet.getString("name");
        return user;
    }
}

import mx.bean.RowMapper;
import mx.bean.User;
import mx.service.IUser;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Test1 {

    @Test
    public void t1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springmvcmvc.xml");
        IUser iUser = (IUser) applicationContext.getBean("iUser");
        System.out.println(iUser.getName(1));
    }

    @Test
    public void t2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springmvcmvc.xml");
        JdbcTemplate template = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
//        template.update("insert into user values(null , ?, ?)", 123, "lisi");
        User user = template.queryForObject("select * from user where id=1", new RowMapper());
        System.out.println(user);

        List<User> users = template.query("select * from user", new RowMapper());
        users.forEach(u -> System.out.println(u.name));
    }

    @Test
    public void t3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springmvcmvc.xml");
        IUser iUser = (IUser) applicationContext.getBean("iUser");
        iUser.setName("new name", 1);
    }

    @Test
    public void t4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springmvcmvc.xml");
        IUser iUser = (IUser) applicationContext.getBean("iUser");
        iUser.changeName(1, 2);
    }
}

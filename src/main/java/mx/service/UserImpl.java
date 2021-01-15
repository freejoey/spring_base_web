package mx.service;

import mx.bean.RowMapper;
import mx.bean.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;

public class UserImpl implements IUser {

    private JdbcTemplate jdbcTemplate;
    private TransactionTemplate transactionTemplate;

    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @PostConstruct
    public void init() {
        System.out.println("init UserImpl.");
    }

    @Override
    public String getName(long id) {
        User user1 = jdbcTemplate.queryForObject("select * from user where id=?", new RowMapper(), id);
        return user1.name;
    }

    @Override
    public void setName(String name, long id) {
        jdbcTemplate.update("update user set name=? where id=?", name, id);
    }

    @Transactional
    @Override
    public void changeName(long first, long second) {
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//                User user1 = jdbcTemplate.queryForObject("select * from user where id=?", new RowMapper(), first);
//                User user2 = jdbcTemplate.queryForObject("select * from user where id=?", new RowMapper(), second);
//                setName(user1.name, second);
//                int a = 1/0;
//                setName(user2.name, first);
//            }
//        });

        User user1 = jdbcTemplate.queryForObject("select * from user where id=?", new RowMapper(), first);
        User user2 = jdbcTemplate.queryForObject("select * from user where id=?", new RowMapper(), second);
        setName(user1.name, second);
        int a = 1 / 0;
        setName(user2.name, first);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

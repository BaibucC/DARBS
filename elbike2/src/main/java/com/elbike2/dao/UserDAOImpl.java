package com.elbike2.dao;

import com.elbike2.model.Bike;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.elbike2.model.User;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.servlet.ModelAndView;

public class UserDAOImpl implements UserDAO {

    private JdbcTemplate jdbcTemplate;

    public UserDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void newEmployee(User user) {
        String sql = "INSERT INTO users (employee)"
                + " VALUES (?)";
        jdbcTemplate.update(sql, user.getEmployee());
    }

    @Override
    public void saveOrUpdate(User user) {
        if (user.getId() > 0) {
            // update
            String sql = "UPDATE users SET name=?, employee=?, date1=?, date2=? WHERE id=?";
            jdbcTemplate.update(sql, user.getName(), user.getEmployee(),
                    user.getDate1(), user.getDate2(), user.getId());
        } else {
            // insert
            String sql = "INSERT INTO users (name, employee, date1, date2)"
                    + " VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, user.getName(), user.getEmployee(),
                    user.getDate1(), user.getDate2());
        }
    }

    @Override
    public void saveBikeEmployee(User user) {
//        if (user.getName().equals("NONE") || user.getDate1().isEmpty() || user.getDate2().isEmpty()) {
//
//        } else {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date newDate1 = format.parse(user.getDate1());
            Date newDate2 = format.parse(user.getDate2());
            long d1 = newDate1.getTime();
            long d2 = newDate2.getTime();
            if (d1 > d2) {
            } else {
                String sql = "UPDATE users SET name=?, date1=?, date2=? WHERE id=?";
                jdbcTemplate.update(sql, user.getName(),
                        user.getDate1(), user.getDate2(), user.getId());
                String sql2 = "UPDATE elbikes SET inuse=1 WHERE bikename=?";
                jdbcTemplate.update(sql2, user.getName());
            }
        } catch (Exception e) {
        }
//        }

    }

    @Override
    public void removeBike(User user) {
        int userId = user.getId();
        String biken = user.getName();
        String sql2 = "UPDATE elbikes SET inuse=0 WHERE bikename=" + biken;
        jdbcTemplate.update(sql2);
        String sql = "UPDATE users SET name='', date1='', date2='' WHERE id=" + userId;
        jdbcTemplate.update(sql);
    }

    @Override
    public void saveOrUpdateBike(Bike bike) {
        if (bike.getId() > 0) {
            // update
            String sql = "UPDATE elbikes SET bikename=?, status=?, inuse=? WHERE id=?";
            jdbcTemplate.update(sql, bike.getBikename(), bike.getStatus(), bike.getInuse(), bike.getId());
        } else {
            // insert
            String sql = "INSERT INTO elbikes (bikename, status, inuse)"
                    + " VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, bike.getBikename(), bike.getStatus(), bike.getInuse());
        }
    }

    @Override
    public void delete(int userId) {
        String sql = "DELETE FROM users WHERE id=?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public void deleteBike(int bikeId) {
        String sql = "DELETE FROM elbikes WHERE id=?";
        jdbcTemplate.update(sql, bikeId);
    }

    @Override
    public List<User> list() {
        String sql = "SELECT * FROM users ORDER BY date2 DESC";
        List<User> listUser = jdbcTemplate.query(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User aUser = new User();

                aUser.setId(rs.getInt("id"));
                aUser.setName(rs.getString("name"));
                aUser.setEmployee(rs.getString("employee"));
                aUser.setDate1(rs.getString("date1"));
                aUser.setDate2(rs.getString("date2"));

                return aUser;
            }
        });
        return listUser;
    }

    @Override
    public List<Bike> optionBike() {
        String sql = "SELECT * FROM elbikes";
        List<Bike> optionBike = jdbcTemplate.query(sql, new RowMapper<Bike>() {
            @Override
            public Bike mapRow(ResultSet rs, int rowNum) throws SQLException {
                Bike oBike = new Bike();
                oBike.setBikename(rs.getString("bikename"));
                return oBike;
            }
        });
        return optionBike;
    }

    @Override
    public List<User> optionUser() {
        String sql = "SELECT * FROM users";
        List<User> optionUser = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User oUser = new User();
                oUser.setEmployee(rs.getString("employee"));
                return oUser;
            }
        });
        return optionUser;
    }

    @Override
    public List<Bike> listBike() {
        String sql = "SELECT * FROM elbikes ORDER BY status DESC, inuse ASC";
        List<Bike> listBike = jdbcTemplate.query(sql, new RowMapper<Bike>() {
            @Override
            public Bike mapRow(ResultSet rs2, int rowNum) throws SQLException {
                Bike abike = new Bike();
                abike.setId(rs2.getInt("id"));
                abike.setBikename(rs2.getString("bikename"));
                abike.setStatus(rs2.getBoolean("status"));
                abike.setInuse(rs2.getBoolean("inuse"));
                return abike;
            }

        });

        listBike.get(0).getStatus().equals("1");
        return listBike;
    }

    @Override
    public List<Bike> listAvailable() {
        String sql = "SELECT * FROM elbikes WHERE status=1 AND inuse=0";
        List<Bike> listAvailable = jdbcTemplate.query(sql, new RowMapper<Bike>() {
            @Override
            public Bike mapRow(ResultSet rs2, int rowNum) throws SQLException {
                Bike abike = new Bike();
                abike.setId(rs2.getInt("id"));
                abike.setBikename(rs2.getString("bikename"));
                abike.setStatus(rs2.getBoolean("status"));
                abike.setInuse(rs2.getBoolean("inuse"));
                return abike;
            }
        });
        return listAvailable;
    }

    @Override
    public Bike getBike(int bikeId) {
        String sql = "SELECT * FROM elbikes WHERE id=" + bikeId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Bike>() {

            @Override
            public Bike extractData(ResultSet rs2) throws SQLException,
                    DataAccessException {
                if (rs2.next()) {
                    Bike bike = new Bike();
                    bike.setId(rs2.getInt("id"));
                    bike.setBikename(rs2.getString("bikename"));
                    bike.setStatus(rs2.getBoolean("status"));
                    bike.setInuse(rs2.getBoolean("inuse"));
                    return bike;
                }
                return null;
            }
        });
    }

    @Override
    public User get(int userId) {
        String sql = "SELECT * FROM users WHERE id=" + userId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {

            @Override
            public User extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setEmployee(rs.getString("employee"));
                    user.setDate1(rs.getString("date1"));
                    user.setDate2(rs.getString("date2"));
                    return user;
                }

                return null;
            }

        });
    }

}

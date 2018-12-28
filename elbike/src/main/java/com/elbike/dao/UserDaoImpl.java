package com.elbike.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.elbike.model.User;

@Repository
public class UserDaoImpl implements UserDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public User findById(Integer id) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);

        String sql = "SELECT * FROM users WHERE id=:id";

        User result = null;
        try {
            result = namedParameterJdbcTemplate.queryForObject(sql, params, new UserMapper());
        } catch (EmptyResultDataAccessException e) {
            // do nothing, return null
        }

        /*
		 * User result = namedParameterJdbcTemplate.queryForObject( sql, params,
		 * new BeanPropertyRowMapper<User>());
         */
        return result;

    }

    @Override
    public List<User> findAll() {

        String sql = "SELECT * FROM users";
        List<User> result = namedParameterJdbcTemplate.query(sql, new UserMapper());

        return result;

    }

    @Override
    public void save(User user) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO USERS(COUNTRY, NAME, DATE1, DATE2, SEX, SKILL) "
                + "VALUES ( :country, :name, :date1, :date2, :sex, :skill)";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user), keyHolder);
        user.setId(keyHolder.getKey().intValue());

    }

    @Override
    public void update(User user) {

        String sql = "UPDATE USERS SET COUNTRY=:country, NAME=:name, DATE1=:date1, DATE2=:date2, "
                + "SEX=:sex, SKILL=:skill WHERE id=:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));

    }

    @Override
    public void delete(Integer id) {

        String sql = "DELETE FROM USERS WHERE id= :id";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));

    }

    private SqlParameterSource getSqlParameterByModel(User user) {

        // Unable to handle List<String> or Array
        // BeanPropertySqlParameterSource
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", user.getId());
                paramSource.addValue("country", user.getCountry());
        paramSource.addValue("name", user.getName());
        paramSource.addValue("date1", user.getDate1());
        paramSource.addValue("date2", user.getDate2());
        paramSource.addValue("sex", user.getSex());
        paramSource.addValue("country", user.getCountry());
        paramSource.addValue("skill", convertListToDelimitedString(user.getSkill()));

        return paramSource;
    }

    private static final class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
                        user.setCountry(rs.getString("country"));
            user.setName(rs.getString("name"));
            user.setDate1(rs.getString("date1"));
            user.setDate2(rs.getString("date2"));
            user.setCountry(rs.getString("country"));
            user.setSex(rs.getString("sex"));
            user.setSkill(convertDelimitedStringToList(rs.getString("skill")));
            return user;
        }
    }

    private static List<String> convertDelimitedStringToList(String delimitedString) {

        List<String> result = new ArrayList<String>();

        if (!StringUtils.isEmpty(delimitedString)) {
            result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
        }
        return result;

    }

    private String convertListToDelimitedString(List<String> list) {

        String result = "";
        if (list != null) {
            result = StringUtils.arrayToCommaDelimitedString(list.toArray());
        }
        return result;

    }

}
package com.elbike2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.elbike2.model.User;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class UserDAOImpl implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	
	public UserDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(User user) {
		if (user.getId() > 0) {
			// update
			String sql = "UPDATE users SET name=?, country=?, date1=?, "
						+ "date2=? WHERE id=?";
			jdbcTemplate.update(sql, user.getName(), user.getCountry(),
					user.getDate1(), user.getDate2(), user.getId());
		} else {
			// insert
			String sql = "INSERT INTO users (name, country, date1, date2)"
						+ " VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, user.getName(), user.getCountry(),
					user.getDate1(), user.getDate2());
		}
		
	}

	@Override
	public void delete(int userId) {
		String sql = "DELETE FROM users WHERE id=?";
		jdbcTemplate.update(sql, userId);
	}

	@Override
	public List<User> list() {
		String sql = "SELECT * FROM users";
		List<User> listUser = jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User aUser = new User();
	
				aUser.setId(rs.getInt("id"));
				aUser.setName(rs.getString("name"));
				aUser.setCountry(rs.getString("country"));
				aUser.setDate1(rs.getString("date1"));
				aUser.setDate2(rs.getString("date2"));
				
				return aUser;
			}
			
		});
		
		return listUser;
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
					user.setCountry(rs.getString("country"));
					user.setDate1(rs.getString("date1"));
					user.setDate2(rs.getString("date2"));
					return user;
				}
				
				return null;
			}
			
		});
	}

}

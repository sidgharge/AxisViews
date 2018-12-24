package com.demo.jdbcviews.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.jdbcviews.models.User;

@Repository
public class UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserMapper userMapper;
	
	public User getUserById(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM user_view WHERE id = ?", new Object[]{id}, userMapper);
	}

	public List<User> getUsers() {
		return jdbcTemplate.query("SELECT * FROM user_view", userMapper);
	}
}

@Component
class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		
		user.setId(rs.getLong("id"));
		user.setEmail(rs.getString("email"));
		user.setName(rs.getString("first_name"));
		
		return user;
	}
	
}

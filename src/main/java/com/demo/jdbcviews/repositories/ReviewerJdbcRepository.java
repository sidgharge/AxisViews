package com.demo.jdbcviews.repositories;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.jdbcviews.models.ReviewerTxbPower;

@Repository
public class ReviewerJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private ReviewerTxbPowerMapper reviewerTxbPowerMapper;

	public ReviewerTxbPower getById(Integer id) {
		return jdbcTemplate.queryForObject(
				"SELECT rev_id, rev_name, rev_key FROM reviewer_txbpower_view WHERE rev_id = ?", new Object[] { id },
				reviewerTxbPowerMapper);
	}

	public List<ReviewerTxbPower> getList(Integer from, Integer size) {
		String query = "SELECT rev_id, rev_name, rev_key FROM reviewer_txbpower_view WHERE rev_key > ? LIMIT ? OFFSET ?";

		return jdbcTemplate.query(query, new Object[] { 1000, size, from }, reviewerTxbPowerMapper);
	}

}

@Component
class ReviewerTxbPowerMapper implements RowMapper<ReviewerTxbPower> {

	@Override
	public ReviewerTxbPower mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReviewerTxbPower reviewerTxbPower = new ReviewerTxbPower();

		map(reviewerTxbPower::setRevId, rs, "rev_id");
		map(reviewerTxbPower::setRevName, rs, "rev_name");
		map(reviewerTxbPower::setRevKey, rs, "rev_key");
		map(reviewerTxbPower::setRevRm, rs, "rev_rm");

		return reviewerTxbPower;
	}

	@SuppressWarnings("unchecked")
	private <T> void map(Consumer<T> c, ResultSet rs, String key) {
		try {
			c.accept((T) rs.getObject(key));
		} catch (SQLException e) {
		}
	}

}

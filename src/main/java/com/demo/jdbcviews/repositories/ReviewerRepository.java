package com.demo.jdbcviews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.jdbcviews.models.ReviewerTxbPower;

public interface ReviewerRepository extends JpaRepository<ReviewerTxbPower, Integer> {

	@Query(value="SELECT r.revId, r.revName, r.revKey from ReviewerTxbPower r WHERE r.revId = :id")
	ReviewerTxbPower getById(@Param("id") Integer id);
}
